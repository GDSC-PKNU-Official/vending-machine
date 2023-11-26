package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ConsoleView implements View{
    @Override
    public String in() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    @Override
    public void out(String data) {
        System.out.println(data);
    }
}
