package ss02_and_03_loop_array_and_method.practice;

import java.util.Scanner;

public class FindMaxElement {
    public static int getMaxElement(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    public static void printArray(int[] arr) {
        for (int temp : arr) {
            System.out.print(temp + "\t");
        }
        System.out.println();
    }

    public static int[] createArray() {
        int n;
        Scanner input = new Scanner(System.in);
        boolean isInvalid;
        do {
            System.out.print("Enter amount of element in array: ");
            n = input.nextInt();
            isInvalid = n < 1 || n > 20;
            if (isInvalid)
                System.out.println("Please enter amount of element in array between 1 and 20");
        } while (isInvalid);
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            System.out.print("array[" + i + "]: ");
            array[i] = input.nextInt();
        }
        return array;
    }

    public static int indexElement(int[] arr, int value) {
        int indexElement = -1;
        for (int i = 0; i < arr.length; i++) {
            if (value == arr[i])
                indexElement = i;
        }
        return indexElement;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] array = createArray();
        System.out.println("Array: ");
        printArray(array);
        int max = getMaxElement(array);
        System.out.println("Max value in array: " + max + " and position: " + indexElement(array, max));
    }
}
