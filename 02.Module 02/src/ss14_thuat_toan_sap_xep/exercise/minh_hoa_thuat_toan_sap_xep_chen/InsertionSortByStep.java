package ss14_thuat_toan_sap_xep.exercise.minh_hoa_thuat_toan_sap_xep_chen;

import java.util.Scanner;

public class InsertionSortByStep {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter array's size: ");
        int size = input.nextInt();
        int[] array = new int[size];
        System.out.println("Enter element's value in array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print("array[" + i + "] = ");
            array[i] = input.nextInt();
        }
        System.out.println("Array have not sort yet");
        printArray(array);
        System.out.println("\nBegin sort processing ....");
        insertionSort(array);
        System.out.println("\nSorted array");
        printArray(array);
    }

    public static void insertionSort(int[] arr) {
        int temp;
        String string = "No insert";
        for (int i = 1; i < arr.length; i++) {
            string = arr[i] + " no insert";
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    string = "Insert: " + arr[j] + " before " + arr[j - 1];
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                } else break;
            }
            System.out.println("List after the " + i + "' sort");
            System.out.println(string);
            printArray(arr);
        }
    }

    public static void printArray(int[] array) {
        for (int a : array)
            System.out.printf("%4d", a);
        System.out.println("\n");
    }
}
