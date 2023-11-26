package controller;

import domain.beverage.Drinks;
import domain.beverage.DrinksFactory;
import view.PaymentOption;
import view.TemperatureOption;
import view.View;

import java.util.function.Supplier;

public class VendingMachineController {

    public void run() {
        View.printStartView();
        final TemperatureOption temperatureOption = retryOnFailure(View::readBeverageTemperature);

        final Drinks drinks = createDrinks(temperatureOption);
        final int beverageSeletion = retryOnFailure(() -> View.readBeverage(drinks.getValue()));
        final PaymentOption paymentOption = retryOnFailure(View::readPaymentOption);


    }

    private <T> T retryOnFailure(final Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (final Exception e) {
            return retryOnFailure(supplier);
        }
    }

    private Drinks createDrinks(final TemperatureOption option) {
        if (option.equals(TemperatureOption.HOT)) {
            return DrinksFactory.createHot();
        }
        if (option.equals(TemperatureOption.ICE)) {
            return DrinksFactory.createIce();
        }

        throw new UnsupportedOperationException("지원하지 않는 옵션입니다.");
    }
}
