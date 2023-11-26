package domain.payment;

import domain.menu.Menu;

public abstract class Payment {
    private int payAmount;
    public abstract int getChangeAmount();
}
