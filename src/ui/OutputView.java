package ui;

public class OutputView extends ConsoleView{
    public void printError(String message) {
        out("[에러] : " + message);
    }
}
