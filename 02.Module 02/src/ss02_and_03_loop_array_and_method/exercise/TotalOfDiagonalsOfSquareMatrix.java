package ss02_and_03_loop_array_and_method.exercise;

import java.util.Scanner;

public class TotalOfDiagonalsOfSquareMatrix {
    public static int getTotalOfDiagonalsOfSquareMatrix(int[][] arr) {
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i][i];
        }
        return total;
    }

    public static int[][] createSqaureMatrix(int length) {
        int[][] arr = new int[length][length];
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print("arr[" + i + "][" + j + "]: ");
                arr[i][j] = input.nextInt();
            }
        }
        return arr;
    }

    public static void printArray2D(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int temp : arr[i]) {
                System.out.print(temp + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSquareMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr.length != arr[i].length)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] array = {{15, 16, 47, 32, 56},
                {46, 94, 67, 79, 13},
                {45, 65, 79, 13, 65},
                {79, 65, 73, 16, 97},
                {48, 98, 15, 35, 79}};
        System.out.println("Array: ");
        printArray2D(array);
        if (!isSquareMatrix(array)) {
            System.out.println("Array is no square matrix. Please type is a square matrix.");
        } else {
            System.out.println("Total of diagonals of square matrix: " + getTotalOfDiagonalsOfSquareMatrix(array));

        }
        //Create square matrix by user
        System.out.print("Enter length of square matrix: ");
        int n = input.nextInt();
        int[][] array2 = createSqaureMatrix(n);
        printArray2D(array2);
        System.out.println("Total of diagonals of square matrix: " + getTotalOfDiagonalsOfSquareMatrix(array2));

    }
}

