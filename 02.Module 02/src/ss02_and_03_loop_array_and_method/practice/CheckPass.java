package ss02_and_03_loop_array_and_method.practice;

import java.util.Scanner;

public class CheckPass {
    public static int[] createArray() {
        int n;
        Scanner input = new Scanner(System.in);
        boolean isInvalid;
        do {
            System.out.print("Enter amount of element in array: ");
            n = input.nextInt();
            isInvalid = n < 1 || n > 30;
            if (isInvalid) System.out.println("Please enter amount of element in array between 1 and 30");
        } while (isInvalid);
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter a mark for student " + (i + 1) + " : ");
            arr[i] = input.nextInt();
        }
        return arr;
    }

    public static int countMarkPass(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 5)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = createArray();
        System.out.println("\nThe number of students passing the exam is " + countMarkPass(arr));
    }
}

/*
public class CheckPass {

    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter a size:");
            size = scanner.nextInt();
            if (size > 30)
                System.out.println("Size should not exceed 30");
        } while (size > 30);
        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Enter a mark for student " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
            i++;
        }
        int count = 0;
        System.out.print("List of mark: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
            if (array[j] >= 5 && array[j] <= 10)
                count++;
        }
        System.out.print("\n The number of students passing the exam is " + count);
    }
}

 */
