package util.message;

import domain.MoneyType;
import domain.Product;
import domain.Temperature;
import domain.UserType;

import java.util.List;
import java.util.Scanner;

import static domain.PaymentMethod.*;
import static domain.UserType.*;

public class SystemMessage {
    public String inputMessage(UserType userType) {
        Scanner sc = new Scanner(System.in);
        if (userType.equals(USER)) {
            System.out.print("사용자 입력 > ");
        } else if (userType.equals(ADMIN)) {
            System.out.print("admin 입력 > ");
        }
        return sc.next();
    }

    public void welcome() {
        System.out.println("""
                [어서와요! GDSC 음료 자판기]
                
                계속 하려면 아무키나 입력하세요 ...
                """);
    }

    public void printTemperatureMenu() {
        divideLine();
        System.out.println("""
                음료를 선택 해주세요 !
                
                [1] 차가운 음료
                [2] 따뜻한 음료
                """);
    }

    public void printPaymentMethodMenu() {
        divideLine();
        System.out.printf("""
                [1] %s
                [2] %s (부가세 10%% 적용)
                
                """, CASH.getPaymentMethod(), CARD.getPaymentMethod());
    }

    public void printProductMenu(List<Product> products, Temperature temperature) {
        divideLine();
        System.out.println("[" + temperature.getTemperature() + "]\n");
        for (Product product : products) {
            System.out.printf("[%d] %s : %d원%n",
                    product.getProductId(),
                    product.getProductName(),
                    product.getCost());
        }
        System.out.println();
    }

    public void printCashMenu(int insertedCash) {
        divideLine();
        System.out.printf("[현금 투입 : %d원]\n\n", insertedCash);

        System.out.println("""
                [1] 5만원권
                [2] 1만원권
                [3] 5천원권
                [4] 1천원권
                [5] 5백원 동전
                [6] 1백원 동전
                [0] 반환
                """);
    }

    public void printResult(Product product) {
        divideLine();
        System.out.printf("""
                이용해주셔서 감사합니다.
                                
                [주문 음료]
                %s
                
                """, product.getProductName());
    }

    public void cashResult(Product product, int insertedCash) {
        printResult(product);

        System.out.printf("""
                [투입 금액]
                %d원
                
                [잔돈]
                %s
                """, insertedCash, returnChange(product, insertedCash));
    }

    public String returnChange(Product product, int insertedCash) {
        StringBuilder sb = new StringBuilder();
        int change = insertedCash - product.getCost();

        int[] moneyTypes = {50000, 10000, 5000, 1000, 500, 100};  // 화폐 단위
        String[] moneyNames = {"50000원권", "10000원권", "5000원권", "1000원권", "500원 동전", "100원 동전"};  // 화폐 이름
        int[] moneyCounts = new int[moneyTypes.length];  // 각 화폐 단위별 개수

        for (int i = 0; i < moneyTypes.length; i++) {
            moneyCounts[i] = change / moneyTypes[i];  // 거스름돈을 해당 화폐 단위로 나눈 몫
            change %= moneyTypes[i];  // 거스름돈을 해당 화폐 단위로 나눈 나머지
        }

        // 결과 출력
        for (int i = 0; i < moneyNames.length; i++) {
            if (moneyCounts[i] > 0) {
                sb.append(moneyNames[i]).append(" : ").append(moneyCounts[i]).append("개\n");
            }
        }
        return sb.toString();
    }

    public void cardResult(Product product) {
        printResult(product);
        System.out.printf("""
                [결제 금액]
                %d원
                """, product.getCost());
    }

    public void divideLine() {
        System.out.print("""
                =============================
                """);
    }
}
