package domain;

import java.math.BigDecimal;

public record Drink(String name, BigDecimal price, BeverageTemperature hotOrIce) {
}
