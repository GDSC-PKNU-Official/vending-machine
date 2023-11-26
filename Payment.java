import java.util.Scanner;

public class Payment {
    String Card;
    int cash;
    static int cashChange = 0;


    int showPayment() {
        Scanner sc = new Scanner(System.in);

        System.out.println("[결제 방식 선택]");
        System.out.println("[1] 현금");
        System.out.println("[2] 카드 (부가세 10% 적용)");
        System.out.println();
        System.out.print("사용자 입력 > ");

        int select_Payment_Method = sc.nextInt();
        System.out.println();
        System.out.println("----------------------------");
        if(select_Payment_Method != 1 || select_Payment_Method != 2)
            System.out.println("잘못된 입력 입니다.");
        return select_Payment_Method;
    }

    void showCash() {
            System.out.println("[현금 투입" + cashChange + "원]");
            System.out.println("[1] 5만원권");
            System.out.println("[2] 1만원권");
            System.out.println("[3] 5천원권");
            System.out.println("[4] 1천원권");
            System.out.println("[5] 500원");
            System.out.println("[6] 100원");
            System.out.println("[0] 반환");
            System.out.println();
            System.out.print("사용자 입력 > ");
        //System.out.println("이용해주셔서 감사합니다.");
    }

    int insertCash() {
        Scanner sc = new Scanner(System.in);
        int select_Cash = sc.nextInt();
        System.out.println("----------------------------");

        if (select_Cash == 1)
            return 50000;
        else if (select_Cash == 2)
            return 10000;
        else if (select_Cash == 3)
            return 5000;
        else if (select_Cash == 4)
            return 1000;
        else if (select_Cash == 5)
            return 500;
        else if (select_Cash == 6)
            return 100;
        return 0;
    }

    void selectCard() {


    }




}
