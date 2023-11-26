package view;

import domain.beverage.BeverageTemperature;
import domain.beverage.Drink;
import domain.pay.Cashes;

import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;

public class View {

    private static final Scanner CONSOLE = new Scanner(System.in);

    private View() {
    }

    public static void printStartView() {
        System.out.print("""
                [어서와요! GDSC 음료 자판기]
                                
                계속 하려면 아무키나 입력하세요 ...
                """);

        CONSOLE.nextLine();
    }

    public static TemperatureOption readBeverageTemperature() {
        System.out.print("""
                ------------------------------
                음료를 선택 해주세요!
                                
                [1] 차가운 음료
                [2] 따뜻한 음료
                                
                사용자 입력>
                """);

        return TemperatureOption.from(CONSOLE.nextLine());
    }

    public static int readBeverage(final Map<Integer, Drink> drinks) {
        System.out.println("------------------------------");

        final BeverageTemperature hotOrIce = drinks.get(1).hotOrIce();
        if (hotOrIce.equals(BeverageTemperature.HOT)) {
            System.out.println("[뜨거운 음료]");
        }
        if (hotOrIce.equals(BeverageTemperature.ICE)) {
            System.out.println("[차가운 음료]");
        }
        System.out.println();

        drinks.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry::getKey))
                .map(entry -> String.format("[%d] ", entry.getKey()) + makeDrinkView(entry.getValue()))
                .forEach(System.out::println);
        System.out.println();

        System.out.println("사용자 입력 > ");
        return readAndParseToInt();
    }

    private static int readAndParseToInt() {
        try {
            return Integer.parseInt(CONSOLE.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    private static String makeDrinkView(final Drink drink) {
        return drink.name() + " : " + drink.price() + "원";
    }

    public static PaymentOption readPaymentOption() {
        System.out.print("""
                ------------------------------
                [결제 방식 선택]
                                
                [1] 현금
                [2] 카드 (부가세 10% 적용)
                                
                사용자 입력 >
                """);

        return PaymentOption.from(CONSOLE.nextLine());
    }

    public static CashOption readCashOption(final Cashes cashes) {
        System.out.println(String.format("""
                ------------------------------
                [현금 투입 : %d원]
                """, cashes.sum().intValue()));

        System.out.print("""
                [1] 5만원권
                [2] 1만원권
                [3] 5천원권
                [4] 1천원권
                [5] 500원
                [6] 100원
                [0] 반환
                                
                사용자 입력 >
                """);
        final int selection = readAndParseToInt();
        return CashOption.from(selection);
    }
}
