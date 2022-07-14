package ss02_and_03_loop_array_and_method.practice;

import java.util.Scanner;

public class ConvertTemperature {
    public static double celsiusToFahrenheit(double celsius) {
        double fahrenheit = (9.0 / 5) * celsius + 32;
        return fahrenheit;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        double celsius = (5.0 / 9) * (fahrenheit - 32);
        return celsius;
    }

    public static void main(String[] args) {
        System.out.println("Function:");
        System.out.println("\t1.Convert celsius to fahrenheit");
        System.out.println("\t2.Convert fahrenheit to celsius");
        System.out.println("\t0.Exit");
        int choice;
        double celsius;
        double fahrenheit;
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    System.out.print("Enter celsius temperature: ");
                    celsius = input.nextDouble();
                    System.out.println("fahrenheit temperature: " + celsiusToFahrenheit(celsius));
                    break;
                case 2:
                    System.out.print("Enter fahrenheit temperature: ");
                    fahrenheit = input.nextDouble();
                    System.out.println("celsius temperature: " + fahrenheitToCelsius(fahrenheit));
                    break;
                default:
                    System.out.println("No choice!");
                    break;
            }
        } while (choice != 0);

    }
}
