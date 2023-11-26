package controller;

import view.OutputView;

public class VendingMachineController {
    public void start() {
        set();
    }

    private void set() {
        OutputView.printWelcomeMessage();
    }
}
