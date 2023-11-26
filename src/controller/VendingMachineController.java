package controller;

import domain.MenuOrder;
import domain.menu.HotMenu;
import domain.menu.IceMenu;
import ui.InputView;
import ui.OutputView;

public class VendingMachineController {

    private final OutputView outputView;
    private final InputView inputView;

    public VendingMachineController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void getBeverage() {
        MenuOrder menuOrder = getMenuOrder();

    }

    private MenuOrder getMenuOrder() {
        int menuType;
        try {
            menuType = Integer.parseInt(inputView.getMenuType());
            if (menuType > 2 || menuType < 1) {
                throw new IllegalArgumentException("메뉴는 1, 2 번중에 골라야 합니다.")
            }
        } catch (NumberFormatException e) {
            outputView.printError("잘못된 메뉴 종류입니다.");
            return getMenuOrder();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return getMenuOrder();
        }
        return getMenu(menuType);
    }

    private MenuOrder getMenu(int menuType) {
        int orderNumber;
        MenuOrder menuOrder = null;
        try {
            if (menuType == 1) {
                orderNumber = Integer.parseInt(inputView.getIceMenuNumber());
                menuOrder = new MenuOrder(IceMenu.getMenu(orderNumber));
            }
            if (menuType == 2) {
                orderNumber = Integer.parseInt(inputView.getHotMenuNumber());
                menuOrder = new MenuOrder(HotMenu.getMenu(orderNumber));
            }
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return getMenu(menuType);
        }
        return menuOrder;
    }
}
