package ss02_and_03_loop_array_and_method.exercise;

import java.util.Scanner;

public class TotalOfColumn {

    public static int getTotalOfColumn(int[][] arr, int col) {
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            if (col < arr[i].length)
                total += arr[i][col];
        }
        return total;
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
        int[][] arr = new int[row][col];
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print("arr[" + i + "][" + j + "]: ");
                arr[i][j] = input.nextInt();
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] array = {{12, 65, 41, 53, 14},
                {45, 16, 32, 45, 78, 32},
                {32, 43, 12, 54, 23},
                {32, 34, 65, 34, 56},
                {43, 76, 87, 23, 66}};
        Scanner input = new Scanner(System.in);
        System.out.println("Array 2D: ");
        printArray2D(array);
        System.out.print("The column that you want to calculate: ");
        int colCalculate = input.nextInt();
        int total = getTotalOfColumn(array, colCalculate);
        System.out.println("Total of column " + colCalculate + ": " + total);
        //created array 2D by user
        System.out.println("Enter amount of element in array: ");
        System.out.print("Enter row of array 2D: ");
        int row = input.nextInt();
        System.out.print("Enter column of array 2D: ");
        int col = input.nextInt();
        int[][] array1 = new int[row][col];
        array1 = createArray2D(row, col);
        System.out.println("Array1 2D: ");
        printArray2D(array1);
        System.out.print("The column that you want to calculate: ");
        colCalculate = input.nextInt();
        total = getTotalOfColumn(array1, colCalculate);
        System.out.print("Total of column " + colCalculate + ": " + total);
    }
}
