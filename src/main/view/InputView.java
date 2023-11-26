package main.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String readContinueStatus(Scanner scanner) {
        System.out.println("계속 하려면 아무키나 입력하세요 ...");
        return scanner.nextLine();
    }

    public static int readBeverageOption(Scanner scanner) {
        System.out.print("사용자 입력 >");
        return scanner.nextInt();
    }

    public static int readBeverageNumber(Scanner scanner) {
        System.out.print("사용자 입력 >");
        return scanner.nextInt();
    }

    public static int getPaymentOption(Scanner scanner) {
        return scanner.nextInt();
    }

    public static int getCashOption(Scanner scanner) {
        return scanner.nextInt();
    }
}