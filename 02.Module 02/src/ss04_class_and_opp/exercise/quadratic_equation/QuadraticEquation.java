package ss04_class_and_opp.exercise.quadratic_equation;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;
    String showB, showC;

    public QuadraticEquation() {
    }

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDiscriminant() {
        return (this.b * this.b - 4 * this.a * this.c);
    }

    public double getRoot1(double delta) {
        return (-this.b + delta) / (2 * this.a);
    }

    public double getRoot2(double delta) {
        return (-this.b - delta) / (2 * this.a);
    }

    public String display() {
        if (this.b < 0)
            showB = " " + this.b;
        else
            showB = " +" + this.b;
        if (this.c < 0)
            showC = " " + this.c;
        else
            showC = " +" + this.c;
        return "Quadratic equation: " + this.a + "*x2" + showB + "*x" + showC + " =0";
    }
}
