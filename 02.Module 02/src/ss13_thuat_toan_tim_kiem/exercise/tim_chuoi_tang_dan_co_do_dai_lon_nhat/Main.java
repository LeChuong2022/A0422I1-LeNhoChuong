package ss13_thuat_toan_tim_kiem.exercise.tim_chuoi_tang_dan_co_do_dai_lon_nhat;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter one string: ");
        String str = input.nextLine();
        char[] strArray = str.toCharArray();
        Character temp = strArray[0];
        String result = String.valueOf(temp);
        for (int i = 1; i < strArray.length; i++) {
            if ((int) temp < (int) strArray[i]) {
                result = result.concat(String.valueOf(strArray[i]));
                temp = strArray[i];
            }
        }
        System.out.println(result);
    }
}
