import java.util.Scanner;

public class Drink {
    String drinkName;
    int price;
    int temperature;

    Drink() {}

    Drink(String drinkName, int price, int temperature) {
        this.drinkName = drinkName;
        this.price = price;
        this.temperature = temperature;
    }

    Payment payment = new Payment();

    void drink() {
        Payment payment = new Payment();

        showDrinkList();

        if (selectDrinkTemperature() == 1) {
            showColdDrinkList();
            payment.showPayment();

        }

        else if (selectDrinkTemperature() == 1) {}

    }

    int userSelectNumber() {
        Scanner sc = new Scanner(System.in);
        int userSelect = sc.nextInt();
        return userSelect;
    }


    int selectDrinkTemperature() {
        int selectNumber = userSelectNumber();
        while(true) {
            if (selectNumber != 1 || selectNumber != 2) {
                System.out.println("잘못된 입력 입니다.");
            }
            return setTemperature(selectNumber);
        }

    }

    void showDrinkList() {
        System.out.println("음료를 선택해 주세요!");
        System.out.println();
        System.out.println("[1] 차가운 음료");
        System.out.println("[2] 따듯운 음료");
        System.out.println();
        System.out.print("사용자 입력 > ");
        System.out.println();
    }

    void coldDrink() {
        Product product = new Product();

    }

    void showColdDrinkList() {
        Product product = new Product();

        System.out.println("[차가운 음료]");
        System.out.println();
        for(Long i : product.drinkList.keySet()){ //저장된 key값 확인
            System.out.println("[" + i + "]" + ": " + product.drinkList.get(i) + "원");
        }
        System.out.println();
        System.out.print("사용자 입력 > ");
        System.out.println();
    }



    void orderDrink() {
        Payment payment = new Payment();
        System.out.println("[주문 음료]");
        System.out.println(drinkName);
        System.out.println("[투입 금액]");
        System.out.println(payment.cashChange + "원");
        System.out.println("[잔돈]");

        //if
        //    System.out.println(payment.cashChange - price + "원 동전 :"  +  + "개");
    }


    public int setTemperature(int temperature) {
        return this.temperature = temperature;
    }


}
