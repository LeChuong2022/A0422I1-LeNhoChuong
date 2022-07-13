package ss02_loop_and_array.exercise;

import java.util.Scanner;

public class FirstPrime {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number;
        int count = 0;
        int prime = 2;
        System.out.print("Enter the number of primes to show: ");
        number = input.nextInt();
        System.out.println("First" + number + "primes: ");
        while (count != number) {
            int i = 2;
            int checkPrime = 0;
            while (i <= Math.sqrt(prime)) {
                if (prime % i == 0) {
                    checkPrime++;
                    break;
                }
                i++;
            }
            if (checkPrime == 0) {
                System.out.print(prime + " ");
                count++;
            }
            prime++;
        }
    }
}
