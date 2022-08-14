package ss11_DSA_stack_queue.exercise.kiem_tra_chuoi_palindrome_queue;

import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String string = input.nextLine();
        string = string.toLowerCase(Locale.ROOT);
        boolean isPalindrome = true;
        String[] characters = string.split("");
        Queue<String> stringQueue = new LinkedList<>();

        for (int i = characters.length - 1; i >= 0; i--) {
            stringQueue.add(characters[i]);

        }

        for (String temp : characters) {
            if (!temp.equals(stringQueue.remove())) {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome)
            System.out.println("String is Palindrome string");
        else
            System.out.println("String is not Palindrome string");

    }
}
