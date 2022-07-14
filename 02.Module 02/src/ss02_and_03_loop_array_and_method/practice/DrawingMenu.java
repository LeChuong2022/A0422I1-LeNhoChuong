package ss02_and_03_loop_array_and_method.practice;

import java.util.Scanner;

public class DrawingMenu {
    public static void main(String[] args) {
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Draw the triangle");
            System.out.println("2. Draw the square");
            System.out.println("3. Draw the rectangle");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Draw the triangle: ");
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 5 - i; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.println("Draw the square:");
                    for (int i = 0; i < 5; i++) {
                        System.out.println("* * * * *");
                    }
                    break;
                case 3:
                    System.out.println("Draw the rectangle");
                    for (int i = 0; i < 3; i++) {
                        System.out.println("* * * * *");
                    }
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}
