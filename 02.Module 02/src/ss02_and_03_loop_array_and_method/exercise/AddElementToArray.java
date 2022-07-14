package ss02_and_03_loop_array_and_method.exercise;

import java.util.Scanner;

public class AddElementToArray {
    static void printArray(int[] arr) {
        for (int temp : arr) {
            System.out.print(temp + " ");
        }
        System.out.println();
    }

    public static int[] addElementToArray(int[] arr, int n, int index) {
        for (int i = arr.length - 2; i >= index; i--) {
            arr[i + 1] = arr[i];
        }
        arr[index] = n;
        return arr;

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        int elementWantsToBeAdded;
        int indexWantsToBeAdded;
        System.out.print("Enter amount of elements in array: ");
        n = input.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            System.out.print("array[" + i + "]: ");
            array[i] = input.nextInt();
        }
        System.out.println("Array: ");
        printArray(array);
        System.out.print("Element wants to be added: ");
        elementWantsToBeAdded = input.nextInt();
        System.out.print("Element position wants to be added: ");
        indexWantsToBeAdded = input.nextInt();
        if (indexWantsToBeAdded <= 1 || indexWantsToBeAdded >= array.length - 1)
            System.out.println("Not executed. (enter index >1 && <" + (array.length - 1) + ")");
        else {
            addElementToArray(array, elementWantsToBeAdded, indexWantsToBeAdded);
            System.out.println("New array: ");
            printArray(array);
        }
    }
}
