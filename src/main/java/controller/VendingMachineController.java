package controller;

import domain.beverage.Drink;
import domain.beverage.Drinks;
import domain.beverage.DrinksFactory;
import domain.pay.CardPayment;
import domain.pay.CashPayment;
import domain.pay.Cashes;
import view.CashOption;
import view.PaymentOption;
import view.TemperatureOption;
import view.View;

import java.math.BigDecimal;
import java.util.function.Supplier;

import static java.util.Objects.isNull;

public class VendingMachineController {

    public void run() {
        View.printStartView();
        final TemperatureOption temperatureOption = retryOnFailure(View::readBeverageTemperature);

        final Drinks drinks = createDrinks(temperatureOption);
        final PaymentOption paymentOption = retryOnFailure(View::readPaymentOption);

        final Drink drink = selectDrink(drinks);
        if (paymentOption.equals(PaymentOption.CARD)) {
            payWithCard(drink);
        }
        if (paymentOption.equals(PaymentOption.CASH)) {
            payWithCash(drink);
        }
    }

    private <T> T retryOnFailure(final Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (final Exception e) {
            System.out.println(e.getMessage());
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

    private Drink selectDrink(final Drinks drinks) {
        return retryOnFailure(() -> {
            final int beverageSelection = retryOnFailure(() -> View.readBeverage(drinks.getValue()));
            final Drink drink = drinks.indexOf(beverageSelection);
            if (isNull(drink)) {
                throw new IllegalArgumentException("존재하지 않는 상품입니다.");
            }

            return drink;
        });
    }

    private void payWithCard(final Drink drink) {
        final CardPayment cardPayment = new CardPayment(drink.price());
        View.printCardPaymentResult(drink, cardPayment.getTotalPrice());
    }

    private void payWithCash(final Drink drink) {
        final CashPayment cashPayment = new CashPayment(drink.price(), Cashes.empty());
        while (cashPayment.isNotAvailableToPay()) {
            final BigDecimal sum = cashPayment.getSum();
            final CashOption cashOption = retryOnFailure(() -> View.readCashOption(sum));

            addCashes(cashOption, cashPayment);
        }

        View.printCashPaymentResult(drink, cashPayment.getSum(), cashPayment.getChange());
    }

    private void addCashes(final CashOption cashOption, final CashPayment cashPayment) {
        if (cashOption.equals(CashOption.CLEAR)) {
            cashPayment.clearTakenCashes();
            return;
        }

        cashPayment.addCash(cashOption.getCash());
    }
}
