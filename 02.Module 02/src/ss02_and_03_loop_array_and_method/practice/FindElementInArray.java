package ss02_and_03_loop_array_and_method.practice;

import java.util.Scanner;

public class FindElementInArray {
    public static int indexElementInArray(String[] str, String name) {
        int index = -1;
        for (int i = 0; i < str.length; i++) {
            if (name.equals(str[i])) {
                index = i;
                return index;
            }
        }
        return index;
    }

    public static void printArray(String[] arr) {
        for (String temp : arr) {
            System.out.println(temp);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] nameStudents = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        System.out.println("Student's list: ");
        printArray(nameStudents);
        String name;
        System.out.print("Enter name's student that you want to find: ");
        name = input.nextLine();
        if (indexElementInArray(nameStudents, name) == -1)
            System.out.println(name + " is not in the list");
        else
            System.out.println("index of " + name + " in the list: " + indexElementInArray(nameStudents, name));
    }
}
