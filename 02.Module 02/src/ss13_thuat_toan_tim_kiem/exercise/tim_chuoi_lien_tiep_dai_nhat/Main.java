package ss13_thuat_toan_tim_kiem.exercise.tim_chuoi_lien_tiep_dai_nhat;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter string: ");
        String string = scanner.nextLine();
        String stringSorted = String.valueOf(string.charAt(0));
        String maxString = String.valueOf(string.charAt(0));
        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i - 1) <= string.charAt(i)) {
                stringSorted = stringSorted.concat(String.valueOf(string.charAt(i)));
                if (maxString.length() < stringSorted.length())
                    maxString = stringSorted;
            } else
                stringSorted = String.valueOf(string.charAt(i));
        }
        System.out.println("Max string: ");
        System.out.println(maxString);
    }
}
