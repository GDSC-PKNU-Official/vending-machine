package main.domain;

import java.util.Arrays;

public class Cash implements Payment{
    private int cashInput = 0;

    public void injectionCash(int inputOption) {
        Arrays.stream(CashDenomination.values())
                .filter(denomination -> denomination.getOption() == inputOption)
                .forEach(denomination -> cashInput += denomination.getValue());
    }

    private int calculateChange(int price) {
        return price - cashInput;
    }
}
