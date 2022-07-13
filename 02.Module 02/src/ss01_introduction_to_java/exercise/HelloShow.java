package ss01_introduction_to_java.exercise;

import java.util.Scanner;

public class HelloShow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;
        System.out.println("Enter your name: ");
        name = scanner.nextLine();
        System.out.println("Hello: " + name);
    }
}
