package domain.pay;

import java.math.BigDecimal;

public enum Cash {
    FIFTY_THOUSAND(BigDecimal.valueOf(500_000)),
    TEN_THOUSAND(BigDecimal.valueOf(100_000)),
    ONE_THOUSAND(BigDecimal.valueOf(10_000)),
    FIVE_HUNDRED(BigDecimal.valueOf(500)),
    ONE_HUNDRED(BigDecimal.valueOf(100)),;

    private final BigDecimal price;

    Cash(final BigDecimal price) {
        this.price = price;
    }

    public BigDecimal add(final Cash other) {
        return price.add(other.price);
    }

    public BigDecimal getPrice() {
        return price;
    }
}
