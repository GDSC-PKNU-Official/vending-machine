package domain.pay;

import java.math.BigDecimal;
import java.math.RoundingMode;

public record CardPayment(BigDecimal requestedPrice) {

    public BigDecimal getTotalPrice() {
        return getTaxedPrice();
    }

    private BigDecimal getTaxedPrice() {
        final BigDecimal tax = requestedPrice.divide(BigDecimal.TEN, RoundingMode.FLOOR);
        return requestedPrice.add(tax);
    }
}
