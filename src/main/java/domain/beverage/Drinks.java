package domain.beverage;

import java.util.Map;

public class Drinks {

    private final Map<Integer, Drink> value;

    public Drinks(final Map<Integer, Drink> value) {
        this.value = value;
    }

    public Map<Integer, Drink> getValue() {
        return value;
    }
}
