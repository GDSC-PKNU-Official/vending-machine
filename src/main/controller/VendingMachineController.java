package main.controller;

import main.view.OutputView;

public class VendingMachineController {
    public void start() {
        set();
    }

    private void set() {
        OutputView.printWelcomeMessage();
    }
}
