package domain.pay;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public record CashPayment(BigDecimal requestedPrice, Cashes cashes) {

    public boolean isNotAvailableToPay() {
        return !cashes.isGreaterOrEqualThan(requestedPrice);
    }

    public void addCash(final Cash cash) {
        cashes.addCash(cash);
    }

    public Cashes getChange() {
        if (isNotAvailableToPay()) {
            throw new IllegalStateException("현재의 금액 총합이 계산할 금액보다 적습니다.");
        }

        final List<Cash> changes = calculateChanges();
        return new Cashes(changes);
    }

    private List<Cash> calculateChanges() {
        BigDecimal remains = cashes.minus(requestedPrice);

        final List<Cash> result = new ArrayList<>();
        for (final Cash cash : Cash.getAllByDescending()) {
            final BigDecimal quotient = divideBy(cash, remains);

            result.addAll(getCashesForAmount(cash, quotient));
            remains = recalculateRemains(cash, remains, quotient);
        }
        return result;
    }

    private BigDecimal divideBy(final Cash cash, final BigDecimal remains) {
        return remains.divide(cash.getPrice(), RoundingMode.FLOOR);
    }

    private List<Cash> getCashesForAmount(final Cash cash, final BigDecimal amount) {
        return Stream.generate(() -> cash)
                .limit(amount.longValue())
                .toList();
    }

    private BigDecimal recalculateRemains(final Cash cash, final BigDecimal remains, final BigDecimal quotient) {
        return remains.subtract(cash.getPrice().multiply(quotient));
    }

    public void clearTakenCashes() {
        cashes.value().clear();
    }

    public BigDecimal getSum() {
        return cashes.sum();
    }
}
