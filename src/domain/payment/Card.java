package domain.payment;

import domain.menu.Menu;

public class Card extends Payment {
    public Card(Menu menu) {
        super(menu);
    }

    @Override
    public int getChangeAmount() {
        return 0;
    }
}
