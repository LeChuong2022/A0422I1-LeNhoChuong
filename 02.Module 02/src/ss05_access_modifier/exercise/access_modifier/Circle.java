package ss05_access_modifier.exercise.access_modifier;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle() {
    }

    public Circle(double r) {
        radius = r;
    }

    double getRadius() {
        return radius;
    } // public + protected + default: ok

    String getColor() { // public && protected: ok
        return color;
    }
}
