package view;

import domain.beverage.BeverageTemperature;
import domain.beverage.Drink;
import domain.pay.Cash;
import domain.pay.Cashes;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

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

    public static CashOption readCashOption(final BigDecimal sumOfCurrentCashes) {
        System.out.printf("""
                ------------------------------
                [현금 투입 : %d원]
                """, sumOfCurrentCashes.intValue());

        System.out.print("""
                [1] 50만원권
                [2] 10만원권
                [3] 1만원권
                [4] 500원
                [5] 100원
                [0] 반환
                                
                사용자 입력 >
                """);
        final int selection = readAndParseToInt();
        return CashOption.from(selection);
    }

    public static void printCardPaymentResult(final Drink drink, final BigDecimal totalPrice) {
        System.out.printf("""
                -------------------------------
                이용해주셔서 감사합니다.
                                
                [주문 음료]
                %s
                                
                [결제 금액]
                %d 원
                """, drink.name(), totalPrice.intValue());
    }

    public static void printCashPaymentResult(final Drink drink,
                                              final BigDecimal takenCashAmount,
                                              final Cashes changes) {
        System.out.printf(
                """
                        ------------------------------
                        이용해주셔서 감사합니다.
                                        
                        [주문 음료]
                        %s
                                        
                        [투입 금액]
                        %d 원
                                        
                        [잔돈]
                        """, drink.name(), takenCashAmount.intValue());
        changes.value().stream()
                .collect(Collectors.groupingBy(Cash::getPrice, Collectors.counting()))
                .entrySet().stream()
                .sorted((cash1, cash2) -> cash2.getKey().compareTo(cash1.getKey()))
                .map(cash -> String.format("%d원 화폐 : %d개", cash.getKey().intValue(), cash.getValue()))
                .forEach(System.out::println);
    }
}
