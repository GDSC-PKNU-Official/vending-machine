package main.view;

import main.domain.Beverage;
import main.domain.Options;

import java.util.List;

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

    public void printBeverages(int optionNumber) {
        Options selectedOption = getOptionByNumber(optionNumber);

        List<Beverage> beverages = selectedOption.getBeverages();

        for (int i = 0; i < beverages.size(); i++) {
            Beverage beverage = beverages.get(i);
            System.out.printf("[%d] %s : %d원\n", i + 1, beverage.name(), beverage.price());
        }
    }

    private Options getOptionByNumber(int optionNumber) {
        return Options.values()[optionNumber - 1];
    }


    public void lineClassification() {
        System.out.println("------------------------------");
    }
}
