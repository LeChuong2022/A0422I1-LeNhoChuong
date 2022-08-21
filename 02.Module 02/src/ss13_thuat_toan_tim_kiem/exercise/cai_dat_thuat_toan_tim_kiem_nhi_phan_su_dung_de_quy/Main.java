package ss13_thuat_toan_tim_kiem.exercise.cai_dat_thuat_toan_tim_kiem_nhi_phan_su_dung_de_quy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arrays = new int[10];
        System.out.println("Enter element of value in arrays: ");
        for (int i = 0; i < arrays.length; i++) {
            System.out.print("element " + i + ": ");
            arrays[i] = input.nextInt();
        }
        Arrays.sort(arrays);
        printArray(arrays);
        System.out.print("\nEnter value you want to find: ");
        int value = input.nextInt();
        System.out.println("Vi tri can tim: " + binarySearch(arrays, 0, arrays.length - 1, value));
        System.out.println("Vi tri can tim (2): " + binarySearch(arrays, 0, arrays.length - 1, 2));
        System.out.println("Vi tri can tim: (3)" + binarySearch(arrays, 0, arrays.length - 1, 3));
        System.out.println("Vi tri can tim: (-5)" + binarySearch(arrays, 0, arrays.length - 1, -5));
        System.out.println("Vi tri can tim: (64)" + binarySearch(arrays, 0, arrays.length - 1, 64));
        System.out.println("Vi tri can tim: (95)" + binarySearch(arrays, 0, arrays.length - 1, 95));
        System.out.println("Vi tri can tim: (103)" + binarySearch(arrays, 0, arrays.length - 1, 103));
        System.out.println("Vi tri can tim: (37)" + binarySearch(arrays, 0, arrays.length - 1, 37));

    }

    static void printArray(int[] a) {
        for (int temp : a) {
            System.out.printf("%4d", temp);
        }
    }

    static int binarySearch(int[] array, int left, int right, int value) {
        if (left > right) return -1;
        int middle = (left + right) / 2;
        if (array[middle] == value)
            return middle;
        else if (array[middle] > value)
            return binarySearch(array, left, middle - 1, value);
        else return binarySearch(array, middle + 1, right, value);
    }
}
