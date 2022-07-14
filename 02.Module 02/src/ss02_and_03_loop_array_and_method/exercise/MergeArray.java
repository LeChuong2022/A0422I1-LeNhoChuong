package ss02_and_03_loop_array_and_method.exercise;

import java.util.Scanner;

public class MergeArray {
    public static int[] enterTheValueOfTheArray(int n) {
        Scanner input = new Scanner(System.in);
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("arr[" + i + "]: ");
            arr[i] = input.nextInt();
        }
        return arr;
    }

    static void printArray(int[] arr) {
        for (int temp : arr) {
            System.out.print(temp + " ");
        }
        System.out.println();
    }

    public static int[] mergeArray(int[] arr1, int[] arr2) {
        int[] arr = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr.length; i++) {
            if (i <= arr1.length - 1) {
                arr[i] = arr1[i];
            } else {
                arr[i] = arr2[i - arr1.length];
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n1;
        int n2;
        System.out.print("Enter amount of elements in array 1: ");
        n1 = input.nextInt();
        int[] array1 = new int[n1];
        array1 = enterTheValueOfTheArray(n1);
        System.out.print("Enter amount of elements in array 2: ");
        n2 = input.nextInt();
        int[] array2 = new int[n2];
        array2 = enterTheValueOfTheArray(n2);
        int[] array3 = new int[n1 + n2];
        array3 = mergeArray(array1, array2);
        System.out.print("Array 1: ");
        printArray(array1);
        System.out.print("Array 2: ");
        printArray(array2);
        System.out.print("Array 3: ");
        printArray(array3);
    }
}
