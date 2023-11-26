import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        run();
    }

    static void run() {
        final String HELLO_VENDING_MACHINE = "[어서와요! GDSC 음료 자판기]";
        final String ANY_KEY_TO_CONTINUE = "계속 하려면 아무키나 입력하세요 ...";
        final String USER_INPUT = "사용자 입력 > ";
        final String LINE = "----------------------------";

        Scanner sc = new Scanner(System.in);
        Drink drink = new Drink();

        System.out.println(HELLO_VENDING_MACHINE);
        System.out.println(ANY_KEY_TO_CONTINUE);
        System.out.println(USER_INPUT);
        sc.next();
        System.out.println(LINE);
        System.out.println();

        drink.drink();
    }
}

