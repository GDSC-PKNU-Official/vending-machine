package main.domain;

public class Credit {
    private final double FEE = 0.1;
    private final int amount;

    public Credit(int price) {
        this.amount = price;
    }

    public int getPaymentAmount() {
        return (int) (amount + amount * FEE);
    }
}
