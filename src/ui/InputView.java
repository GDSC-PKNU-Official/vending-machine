package ui;

import domain.menu.HotMenu;
import domain.menu.IceMenu;
import domain.menu.Menu;

public class InputView extends ConsoleView {
    public String getMenuType() {
        out(Menu.INTRODUCTION_MESSAGE);
        return in();
    }

    public String getIceMenuNumber() {
        StringBuilder sb = new StringBuilder();
        sb.append("------------------------------\n" + "[차가운 음료]\n\n");
        for (Menu menu : IceMenu.values()) {
            if (menu == IceMenu.NONE) {
                continue;
            }
            sb.append("[" + menu.getNumber() + "] " + menu.getName() + " : " + String.format("%,d", menu.getPrice() + "원\n"));
        }
        out(sb.toString());
        return in();
    }

    public String getHotMenuNumber() {
        StringBuilder sb = new StringBuilder();
        sb.append("------------------------------\n" + "[뜨거운 음료]\n\n");
        for (Menu menu : HotMenu.values()) {
            if (menu == HotMenu.NONE) {
                continue;
            }
            sb.append("[" + menu.getNumber() + "] " + menu.getName() + " : " + String.format("%,d", menu.getPrice() + "원"));
        }
        out(sb.toString());
        return in();
    }

    public String getPaymentType() {
        out("------------------------------\n" + "[결제 방식 선택]");
        return in();
    }
}
