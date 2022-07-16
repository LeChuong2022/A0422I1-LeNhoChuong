package ss04_class_and_opp.exercise.quadratic_equation;

public class SolvingEquation {
    private double a;
    private double b;

    public SolvingEquation() {
    }

    public SolvingEquation(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getRoot() {
        return (-this.b / this.a);
    }
}
