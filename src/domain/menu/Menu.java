package domain.menu;

public interface Menu {
    String INTRODUCTION_MESSAGE = "------------------------------\n" +
            "음료를 선택 해주세요!\n" +
            "\n" +
            "[1] 차가운 음료\n" +
            "[2] 따뜻한 음료\n";

    String getIntroductionMessage();
    Menu getMenu(int number);
    int getNumber();
    int getPrice();
    String getName();

}
