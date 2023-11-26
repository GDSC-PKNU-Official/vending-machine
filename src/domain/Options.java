package domain;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Options {
    COLD("차가운 음료",List.of(
            new Beverage("스프라이트 ", 1500),
            new Beverage("코카콜라", 1300),
            new Beverage("솔의눈  ", 1000),
            new Beverage("펩시 콜라 ", 1100)
    )),
    HOT("따뜻한 음료", List.of(
            new Beverage("TOP커피", 1800),
            new Beverage("꿀물", 1500),
            new Beverage("홍삼차 ", 1700),
            new Beverage("단팥죽  ", 2100)
    ));

    private static final Map<String, Options> beverageToOptions = new HashMap<>();

    static {
        for (Options menu : Options.values()) {
            for (Beverage food : menu.beverages) {
                beverageToOptions.put(food.name(), menu);
            }
        }
    }

    private final String options;
    private final List<Beverage> beverages;

    Options(String options, List<Beverage> beverages) {
        this.options = options;
        this.beverages = beverages;
    }

    public String getOptions() {
        return options;
    }

    public List<Beverage> getBeverages() {
        return beverages;
    }
}
