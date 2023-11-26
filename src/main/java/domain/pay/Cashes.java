package domain.pay;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public record Cashes(List<Cash> value) {

    public static Cashes empty() {
        return new Cashes(new ArrayList<>());
    }

    public boolean isGreaterOrEqualThan(final BigDecimal price) {
        final BigDecimal sum = sum();
        return sum.compareTo(price) >= 0;
    }

    public BigDecimal sum() {
        return value.stream()
                .map(Cash::getPrice)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    public BigDecimal minus(final BigDecimal price) {
        return sum().subtract(price);
    }

    public void addCash(final Cash cash) {
        value.add(cash);
    }
}
