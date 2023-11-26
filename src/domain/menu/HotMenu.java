package domain.menu;

import java.util.Arrays;

public enum HotMenu implements Menu {
    TOP(1, "TOP커피", 1_800),
    HONEY_WATER(2, "꿀물", 1_500),
    HONGSAM(3, "홍삼차", 1_700),
    DANPAT(4, "단팥죽", 2_100),
    NONE(-1, "없음", 0);

    private int number;
    private String name;
    private int price;

    HotMenu(int number, String name, int price) {
        this.number = number;
        this.name = name;
        this.price = price;
    }

    public String getIntroductionMessage() {
        return INTRODUCTION_MESSAGE;
    }

    @Override
    public Menu getMenu(int number) {
        return Arrays.stream(HotMenu.values())
                .filter(hotMenu -> hotMenu.number == number)
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


}
