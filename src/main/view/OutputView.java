package main.view;

import main.domain.Options;

public class OutputView {

    public static void printException(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public static void printWelcomeMessage() {
        System.out.println("[어서와요! GDSC 음료 자판기]");
    }

    public static void printOptionsSelection() {
        System.out.println("음료를 선택 해주세요!");
    }

    public static void printOptions() {
        for (Options option : Options.values()) {
            System.out.println("[" + (option.ordinal() + 1) + "] " + option.getOptions());
        }
    }
}
