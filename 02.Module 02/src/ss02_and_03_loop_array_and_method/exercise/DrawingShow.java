package ss02_and_03_loop_array_and_method.exercise;

import java.util.Scanner;

public class DrawingShow {
    static void printTheRectangle() {
        int width;
        int height;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter width of rectangle: ");
        width = input.nextInt();
        System.out.print("Enter height of rectangle: ");
        height = input.nextInt();
        System.out.println("Print the rectangle");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    static void printTheSquareTriangle() {
        int width;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter width of square triangle: ");
        width = input.nextInt();
        System.out.println("Print the square triangle (bottom-left)");
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
        System.out.println("Print the square triangle (bottom-right)");
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                if (j < width - 1 - i)
                    System.out.print("   ");
                else
                    System.out.print(" * ");
            }
            System.out.println();
        }
        System.out.println("Print the square triangle (top-left)");
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width - i; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
        System.out.println("Print the square triangle (top-right)");
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                if (j >= i)
                    System.out.print(" * ");
                else
                    System.out.print("   ");

            }
            System.out.println();
        }
    }

    static void printIsoscelesTriangle() {
        int height;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter height of isosceles triangle: ");
        height = input.nextInt();
        System.out.println("Print the isosceles triangle");
        for (int i = 0; i < height; i++) {
            for (int j = 1; j <= height * 2 - 1; j++) {
                if (j >= height - i && j <= height + i)
                    System.out.print(" * ");
                else
                    System.out.print("   ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice = -1;
        boolean isInvalid;
        System.out.println("Menu: ");
        System.out.println("\t 1.Print the rectangle");
        System.out.println("\t 2.Print the square (The corner is square at 4 different angles: top-left, top-right, bottom-left, bottom-right");
        System.out.println("\t 3.Print isosceles triangle");
        System.out.println("\t 4.Exit");
        System.out.print("Enter your choice: ");
        do {
            choice = input.nextInt();
            isInvalid = choice < 1 || choice > 4;
            if (isInvalid)
                System.out.println("Please enter number from 1 to 4");
        } while (isInvalid);
        switch (choice) {
            case 1:
                printTheRectangle();
                break;
            case 2:
                printTheSquareTriangle();
                break;
            case 3:
                printIsoscelesTriangle();
                break;
            case 4:
                System.out.println("Exit");
        }
    }
}
