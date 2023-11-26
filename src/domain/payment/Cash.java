package domain.payment;

import domain.menu.IceMenu;
import domain.menu.Menu;

import java.util.List;

public class Cash extends Payment {

    public Cash(int payAmount) {
        this.payAmount = payAmount;
    }

    @Override
    public int getChangeAmount() {

    }

    class MoneyType {
        private String name;
        private int value;

        public MoneyType(String name, int value) {
            this.name = name;
            this.value = value;
        }
    }
}
