package ss06_inheritance.exercise.circle_and_cylinder;

public class MainCircleAndCylinder {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);
        Cylinder cylinder = new Cylinder();
        cylinder.setHeight(10.0);
        System.out.println(cylinder);
    }
}
