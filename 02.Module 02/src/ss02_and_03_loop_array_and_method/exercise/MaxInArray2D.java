package ss02_and_03_loop_array_and_method.exercise;

import java.util.Scanner;

public class MaxInArray2D {

    public static void getMaxInArray2D(int[][] arr) {
        int max = arr[0][0];
        int indexRow = 0;
        int indexCol = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                    indexRow = i;
                    indexCol = j;
                }
            }
        }
        System.out.println("Max value in array 2D: " + max);
        System.out.println("Element position is: \nRow: " + indexRow + "\nColumn: " + indexCol);
    }

    public static void printArray2D(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int temp : arr[i]) {
                System.out.print(temp + " ");
            }
            System.out.println();
        }
    }

    public static int[][] createArray2D(int row, int col) {
        Scanner input = new Scanner(System.in);
        int[][] arr = new int[row][col];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print("arr[" + i + "][" + j + "]: ");
                arr[i][j] = input.nextInt();
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] array = {{12, 15, 16, 21},
                {15, 16, 98, 54, 65, 49, 52},
                {45, 65, 17, 32, 45},
                {45, 78, 46, 13, 47}};
        System.out.println("Array 2D: ");
        printArray2D(array);
        getMaxInArray2D(array);

        int[][] array1 = {{13, 52, 94, 28, 49},
                {84, 20, 48, 5, 3, 21, 42},
                {74, 2, 4, 35, 34, 75, 23},
                {96, 34, 12, 54, 3, 42, 54}
        };
        System.out.println("Array 2D: ");
        printArray2D(array1);
        getMaxInArray2D(array1);
        //Created Array By User
        System.out.println("Enter amount of element in array 2D: ");
        System.out.print("Enter amount of rows: ");
        int row = input.nextInt();
        System.out.print("Enter amount of columns: ");
        int col = input.nextInt();
        int[][] array2 = new int[row][col];
        array2 = createArray2D(row, col);
        printArray2D(array2);
        getMaxInArray2D(array2);
    }
}
