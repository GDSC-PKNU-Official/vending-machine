package view;

import domain.pay.Cash;

import java.util.Arrays;

public enum CashOption {
    FIVE_HUNDRED_THOUSAND(1, Cash.FIVE_HUNDRED_THOUSAND),
    ONE_HUNDRED_THOUSAND(2, Cash.ONE_HUNDRED_THOUSAND),
    TEN_THOUSAND(3, Cash.TEN_THOUSAND),
    FIVE_HUNDRED(4, Cash.FIVE_HUNDRED),
    ONE_HUNDRED(5, Cash.ONE_HUNDRED),
    CLEAR(0, null),
    ;

    private final int selection;
    private final Cash cash;

    CashOption(final int selection, final Cash cash) {
        this.selection = selection;
        this.cash = cash;
    }

    public static CashOption from(final int selection) {
        return Arrays.stream(CashOption.values())
                .filter(option -> option.selection == selection)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 옵션입니다."));
    }

    public Cash getCash() {
        return cash;
    }
}
