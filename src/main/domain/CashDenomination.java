package main.domain;

public enum CashDenomination {
    FIFTY_THOUSAND_WON(1, 50000),
    TEN_THOUSAND_WON(2, 10000),
    FIVE_THOUSAND_WON(3, 5000),
    ONE_THOUSAND_WON(4, 1000),
    FIVE_HUNDRED_WON(5, 500),
    ONE_HUNDRED_WON(6, 100);

    private final int option;
    private final int value;

    CashDenomination(int option, int value) {
        this.option = option;
        this.value = value;
    }

    public int getOption() {
        return option;
    }

    public int getValue() {
        return value;
    }
}