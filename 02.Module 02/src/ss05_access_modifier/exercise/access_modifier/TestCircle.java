package ss05_access_modifier.exercise.access_modifier;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle1 = new Circle();
        System.out.println("Radius circle1: " + circle1.getRadius());
        System.out.println("Color circle1: " + circle1.getColor());
        Circle circle2 = new Circle(2.0);
        System.out.println("Radius circle2: " + circle2.getRadius());
        System.out.println("Color circle2: " + circle2.getColor());
    }
}
