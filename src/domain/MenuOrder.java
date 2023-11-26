package domain;

import domain.menu.HotMenu;
import domain.menu.IceMenu;
import domain.menu.Menu;

public class MenuOrder {
    private Menu menu;

    public MenuOrder(Menu menu) {
        this.menu = menu;
    }

    private void validateOrder(Menu menu) {
        if (menu == HotMenu.NONE || menu == IceMenu.NONE ) {
            throw new IllegalArgumentException("잘못된 주문입니다.\n");
        }
    }
}
