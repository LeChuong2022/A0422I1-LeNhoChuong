package ss02_and_03_loop_array_and_method.practice;

import java.util.Scanner;

public class InterestCalculation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter investment amount: ");
        int moneySave = scanner.nextInt();
        System.out.print("Enter number of months: ");
        int month = scanner.nextInt();
        System.out.print("Enter annual interest rate in percentage: ");
        double interestRate = scanner.nextDouble();
        double totalInterest = moneySave;
        for (int i = 1; i <= month; i++) {
            totalInterest += totalInterest * interestRate / 100 / 12;
        }
        System.out.println("Total of interest: " + totalInterest);
    }
}
