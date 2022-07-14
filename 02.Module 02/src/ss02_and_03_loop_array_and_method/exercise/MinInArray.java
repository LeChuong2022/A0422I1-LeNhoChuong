package ss02_and_03_loop_array_and_method.exercise;

import java.util.Scanner;

public class MinInArray {

    public static int[] createArray(int n) {
        Scanner input = new Scanner(System.in);
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("arr[" + i + "]: ");
            arr[i] = input.nextInt();
        }
        return arr;
    }

    public static int findMinInArray(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i])
                min = arr[i];
        }
        return min;
    }

    static void printArray(int[] arr) {
        for (int temp : arr) {
            System.out.print(temp + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        System.out.print("Enter amount of elements in array: ");
        n = input.nextInt();
        int[] array;
        array = createArray(n);
        System.out.print("Array: ");
        printArray(array);
        System.out.println("Min value in array: " + findMinInArray(array));
    }
}
