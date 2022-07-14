package ss02_and_03_loop_array_and_method.practice;

import java.util.Scanner;

public class ReverseArray {
    public static int[] reverseArray(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        return arr;
    }

    public static int[] createArrayLess20Element() {
        int n;
        Scanner input = new Scanner(System.in);
        boolean isInvalid;
        do {
            System.out.print("Enter amount of elements in array: ");
            n = input.nextInt();
            isInvalid = n > 20 || n < 1;
            if (isInvalid)
                System.out.println("Please enter amount of element in array between 1 and 20 ");
        } while (isInvalid);
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("arr[" + i + "]: ");
            arr[i] = input.nextInt();
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int temp : arr) {
            System.out.print(temp + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = createArrayLess20Element();
        System.out.println("Array: ");
        printArray(array);
        reverseArray(array);
        System.out.printf("\n%-20s%s", "New array (after reverse array): ", "");
        printArray(array);
//        int[] array1 = createArrayLess20Element();
//        printArray(array);
//        printArray(array1);
    }
}

/*
public class ReverseArray {

    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter a size:");
            size = scanner.nextInt();
            if (size > 20)
                System.out.println("Size does not exceed 20");
        } while (size > 20);
        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Enter element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
            i++;
        }
        System.out.printf("%-20s%s", "Elements in array: ", "");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
        for (int j = 0; j < array.length / 2; j++) {
            int temp = array[j];
            array[j] = array[size - 1 - j];
            array[size - 1 - j] = temp;
        }
        System.out.printf("\n%-20s%s", "Reverse array: ", "");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
    }
}
*/