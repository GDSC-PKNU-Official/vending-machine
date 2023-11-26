package domain;

import java.util.List;

public enum MoneyType {
    PAPER_50000("5만원권"),
    PAPER_10000("1만원권"),
    PAPER_5000("5천원권"),
    PAPER_1000("1천원권"),
    COIN_500("5백원 동전"),
    COIN_100("1백원 동전"),
    ;

    private String money;

    MoneyType(String money) {
        this.money = money;
    }

    public String getMoney() {
        return money;
    }
}
