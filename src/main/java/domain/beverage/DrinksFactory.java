package domain.beverage;

import java.math.BigDecimal;
import java.util.List;

public class DrinksFactory {

    private DrinksFactory() {
    }

    public static Drinks create() {
        final List<Drink> drinks = List.of(
                new Drink("스프라이트", BigDecimal.valueOf(1_500L), BeverageTemperature.ICE),
                new Drink("코카콜라", BigDecimal.valueOf(1_300L), BeverageTemperature.ICE),
                new Drink("솔의눈", BigDecimal.valueOf(1_000L), BeverageTemperature.ICE),
                new Drink("펩시 콜라", BigDecimal.valueOf(1_100L), BeverageTemperature.ICE),

                new Drink("TOP커피", BigDecimal.valueOf(1_800L), BeverageTemperature.HOT),
                new Drink("꿀물", BigDecimal.valueOf(1_500L), BeverageTemperature.HOT),
                new Drink("홍삼차", BigDecimal.valueOf(1_700L), BeverageTemperature.HOT),
                new Drink("단팥죽", BigDecimal.valueOf(2_100L), BeverageTemperature.HOT)
        );

        return new Drinks(drinks);
    }
}
