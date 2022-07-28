package ss07_abstract_class_and_interface.exercise.interface_colorable_cho_cac_lop_hinh_hoc;

public class CircleColorableTest {
    public static void main(String[] args) {
        Circle[] circles = new Circle[3];
        circles[0] = new CircleColorable();
        circles[1] = new CircleColorable(10);
        circles[2] = new CircleColorable(100, "red", false);
        System.out.println("Pre - filled");
        for (Circle circle : circles) {
            circle.setFilled(false);
            System.out.println(circle);
        }
        System.out.println("After - filled");
        for (Circle circle : circles) {
            if (circle instanceof CircleColorable) {
                Colorable colorable = (CircleColorable) circle;
                colorable.howToColor("pink");
                System.out.println(circle);
            }
        }
    }
}
