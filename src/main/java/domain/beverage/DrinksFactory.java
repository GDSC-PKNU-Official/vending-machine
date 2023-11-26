package domain.beverage;

import java.math.BigDecimal;
import java.util.Map;

public class DrinksFactory {

    private DrinksFactory() {
    }

    public static Drinks createIce() {
        final Map<Integer, Drink> drinks = Map.of(
                1, new Drink("스프라이트", BigDecimal.valueOf(1_500L), BeverageTemperature.ICE),
                2, new Drink("코카콜라", BigDecimal.valueOf(1_300L), BeverageTemperature.ICE),
                3, new Drink("솔의눈", BigDecimal.valueOf(1_000L), BeverageTemperature.ICE),
                4, new Drink("펩시 콜라", BigDecimal.valueOf(1_100L), BeverageTemperature.ICE));

        return new Drinks(drinks);
    }

    public static Drinks createHot() {
        final Map<Integer, Drink> drinks = Map.of(
                1, new Drink("TOP커피", BigDecimal.valueOf(1_800L), BeverageTemperature.HOT),
                2, new Drink("꿀물", BigDecimal.valueOf(1_500L), BeverageTemperature.HOT),
                3, new Drink("홍삼차", BigDecimal.valueOf(1_700L), BeverageTemperature.HOT),
                4, new Drink("단팥죽", BigDecimal.valueOf(2_100L), BeverageTemperature.HOT));

        return new Drinks(drinks);
    }
}
