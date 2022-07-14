package ss02_and_03_loop_array_and_method.exercise;

import java.util.Scanner;

public class TimesOccurrencesOfCharacterInString {
    public static int getTimeOccurrencesInString(String str, char character) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (character == str.charAt(i))
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str;
        char character;
        System.out.print("Enter a string: ");
        str = input.nextLine();
        System.out.print("Enter a character: ");
        character = input.next().charAt(0);
        System.out.print("Times of occurrences of " +
                character + " in " + str + " : " + getTimeOccurrencesInString(str, character));

    }
}
