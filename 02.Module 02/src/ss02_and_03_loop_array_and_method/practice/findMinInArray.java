package ss02_and_03_loop_array_and_method.practice;

public class findMinInArray {
    public static int indexMinInArray(int[] arr) {
        int index = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[index])
                index = i;
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = {4, -2, 5, 32, 13, 54};
        int index = indexMinInArray(arr);
        System.out.println("The smallest element in the array is: " + arr[index] + " and position: " + index);
    }
}
