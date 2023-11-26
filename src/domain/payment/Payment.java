package domain.payment;

import domain.menu.Menu;

public class Payment {
    private final Menu menu;

    public Payment(final Menu menu) {
        this.menu = menu;
    }

    public int getChangeAmount() {
        return 0;
    }
}
