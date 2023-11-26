package domain;

public enum PaymentMethod {
    CASH("현금"),
    CARD("카드"),
    ;

    private String paymentMethod;

    PaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
}
