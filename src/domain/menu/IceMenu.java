package domain.menu;

import java.util.Arrays;

public enum IceMenu implements Menu {
    SPRITE(1, "스프라이트", 1_500),
    COKA(2, "코카콜라", 1_300),
    SOLE(3, "솔의눈", 1_000),
    PEPSI(4, "펩시 콜라", 1_100),
    NONE(-1, "없음", 0);
    private int number;
    private String name;
    private int price;

    IceMenu(int number, String name, int price) {
        this.number = number;
        this.name = name;
        this.price = price;
    }

    @Override
    public String getIntroductionMessage() {
        return INTRODUCTION_MESSAGE;
    }

    @Override
    public Menu getMenu(int number) {
        return Arrays.stream(IceMenu.values())
                .filter(iceMenu -> iceMenu.number == number)
                .findFirst()
                .orElse(NONE);
    }

    @Override
    public int getNumber() {
        return this.number;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public String getName() {
        return this.name;
    }

//
//    @Override
//    public String toString() {
//
//    }
}
