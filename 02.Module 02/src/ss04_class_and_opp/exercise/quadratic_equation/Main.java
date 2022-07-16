package ss04_class_and_opp.exercise.quadratic_equation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("The quadratic equation:\nEnter a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter b: ");
        double b = scanner.nextDouble();
        System.out.print("Enter c: ");
        double c = scanner.nextDouble();
        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
        System.out.println(quadraticEquation.display());
        double delta = quadraticEquation.getDiscriminant();
        if (a == 0) {
            if (b == 0) {
                if (c == 0)
                    System.out.println("The equation has infinitely many roots");
                else
                    System.out.println("The equation has no roots");
            } else {
                SolvingEquation solvingEquation = new SolvingEquation(b, c);
                System.out.println("The equation has a root: x = " + solvingEquation.getRoot());
            }
        } else {
            if (delta < 0) {
                System.out.println("The equation has no roots");
            } else if (delta == 0) {
                System.out.println("The equation has a double root: x1 = x2 = " + quadraticEquation.getRoot1(Math.sqrt(delta)));
            } else {
                System.out.println("The equation has 2 roots: \nx1 = " +
                        quadraticEquation.getRoot1(Math.sqrt(delta)) + "\nx2 = " + quadraticEquation.getRoot2(Math.sqrt(delta)));
            }
        }
    }
}
