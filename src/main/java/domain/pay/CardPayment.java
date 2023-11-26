package domain.pay;

import java.math.BigDecimal;

public record CardPayment(BigDecimal requestedPrice) implements Payable {

    @Override
    public boolean proceedPayment() {
        return true;
    }

    @Override
    public BigDecimal getTotalPrice() {
        return getTaxedPrice();
    }

    @Override
    public void addCash(final Cash cash) {
        throw new UnsupportedOperationException();
    }

    private BigDecimal getTaxedPrice() {
        final BigDecimal tax = requestedPrice.divide(BigDecimal.TEN);
        return requestedPrice.add(tax);
    }
}
