package domain.payment;

import domain.menu.IceMenu;
import domain.menu.Menu;

public class Cash extends Payment{
    private int payAmount;
    public Cash(Menu menu, int payAmount) {
        super(menu);
        this.payAmount = payAmount;
    }

    @Override
    public int getChangeAmount() {
    }
}
