package domain.pay;

import java.math.BigDecimal;
import java.util.List;

public record Cashes(List<Cash> value) {

    public boolean isGreaterOrEqualThan(final BigDecimal price) {
        final BigDecimal sum = sum();
        return sum.compareTo(price) >= 0;
    }

    private BigDecimal sum() {
        return value.stream()
                .map(Cash::getPrice)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    public BigDecimal minus(final BigDecimal price) {
        return sum().subtract(price);
    }

    @Override
    public List<Cash> value() {
        return value;
    }
}
