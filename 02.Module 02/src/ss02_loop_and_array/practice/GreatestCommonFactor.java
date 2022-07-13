package ss02_loop_and_array.practice;

import java.util.Scanner;

public class GreatestCommonFactor {
    public static void main(String[] args) {
        int a;
        int b;
        int greatestCommonFactor;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a: ");
        a = input.nextInt();
        System.out.println("Enter b: ");
        b = input.nextInt();
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0 || b == 0) {
            if (a == 0 && b == 0)
                System.out.println("No greatest common factor");
            else {
                if (a != 0)
                    System.out.println("Greatest common factor of " + a + " and " + b + ": " + a);
                else
                    System.out.println("Greatest common factor of " + a + " and " + b + ": " + b);
            }
        } else {
            int i;
            if (a > b)
                i = b;
            else
                i = a;
            while (true) {
                if (a % i == 0 && b % i == 0) {
                    greatestCommonFactor = i;
                    break;
                }
                i--;
            }
            System.out.println("Greatest common factor of " + a + " and " + b + ": " + greatestCommonFactor);
        }
    }
}

