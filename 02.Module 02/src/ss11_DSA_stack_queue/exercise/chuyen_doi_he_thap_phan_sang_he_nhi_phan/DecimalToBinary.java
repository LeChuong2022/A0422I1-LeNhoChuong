package ss11_DSA_stack_queue.exercise.chuyen_doi_he_thap_phan_sang_he_nhi_phan;

import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinary {
    public static void main(String[] args) throws Exception {
        Stack<Integer> stack = new Stack<Integer>();
        System.out.printf("Enter a number: ");
        Scanner input = new Scanner(System.in);
        int number;
        number = input.nextInt();
        while (number != 0) {
            stack.push(number % 2);
            number /= 2;
        }
        while (stack.size() != 0) {
            System.out.print(stack.pop());
        }
    }
}
