package domain.beverage;

import java.util.List;

public class Drinks {

    private final List<Drink> value;

    public Drinks(final List<Drink> value) {
        this.value = value;
    }

    public List<Drink> getValue() {
        return value;
    }
}
