package ss13_thuat_toan_tim_kiem.practice.tinh_do_phuc_tap_cua_thuat_toan;

import java.util.Scanner;

public class AlgorithmComplexityTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String inputString = scanner.nextLine();
        int[] frequentChar = new int[255];
        for (int i = 0; i < inputString.length(); i++) {
            //Tìm vị trí tương ứng của ký tự trong bảng ASCII
            int ascii = (int) inputString.charAt(i);
            //Tăng giá trị tần suất
            frequentChar[ascii] += 1;
        }
        int max = 0;
        char character = (char) 255; /*empty character*/
        for (int i = 0; i < 255; i++) {
            if (frequentChar[i] > max) {
                max = frequentChar[i];
                character = (char) i;
            }
        }
        System.out.println("The most appearing letter is '" + character + "' with a frequency of " + max + " times");
    }
}
