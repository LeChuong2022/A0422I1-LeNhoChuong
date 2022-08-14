package ss11_DSA_stack_queue.exercise.kiem_tra_dau_ngoac_stack;

import java.util.Scanner;
import java.util.Stack;

public class BracketStack {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean isCorrectMathExpression = true;
        String left = null;
        Stack<String> bStack = new Stack();
        System.out.println("Enter math expression: ");
        String mathExpression = input.nextLine();
        String[] syms = mathExpression.split("");
        for (String sym : syms) {
            left = null;
            if (sym.equals("("))
                bStack.push(sym);
            else if (sym.equals(")")) {
                if (bStack.isEmpty()) {
                    isCorrectMathExpression = false;
                    break;
                }
                left = bStack.pop();
                if (!left.equals("(")) {
                    isCorrectMathExpression = false;
                    break;
                }
            }
        }
        if (isCorrectMathExpression && bStack.isEmpty())
            System.out.println("\nMath expression is correct");
        else
            System.out.println("\nMath expression is not correct");
    }
}
