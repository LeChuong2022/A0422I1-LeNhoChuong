package ss02_and_03_loop_array_and_method.exercise;

import java.util.Scanner;

public class RemoveElementFromArray {
    public static int[] removeElementFromArray(int[] arr) {
        System.out.print("\nEnter the element you want to remove: ");
        Scanner input = new Scanner(System.in);
        int x;
        x = input.nextInt();
        int index;
        for (int i = 0; i < arr.length; i++) {
            if (x == arr[i]) {
                index = i;
                for (int j = index; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[arr.length - 1] = 0;
                i = -1;
            }
        }
        return arr;
    }

    static void printArray(int[] arr) {
        for (int temp : arr) {
            System.out.print(temp + " ");
        }
    }

    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter amount of element in array: ");
        n = input.nextInt();
        int[] array = new int[n];
        System.out.println("Enter value of element in array: ");
        for (int i = 0; i < n; i++) {
            System.out.print("array[" + i + "]: ");
            array[i] = input.nextInt();
        }
        System.out.println("Array: ");
        printArray(array);
        removeElementFromArray(array);
        System.out.println("New array: ");
        printArray(array);
    }
}
