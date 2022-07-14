package ss01_introduction_to_java.exercise;

import java.util.Scanner;

public class CurrencyConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rate = 23000;
        System.out.printf("Currency Converter: \nUSD: ");
        double dollarUSA = scanner.nextDouble();
        double vnd = rate * dollarUSA;
        System.out.printf("=> VND: " + vnd);
    }
}
