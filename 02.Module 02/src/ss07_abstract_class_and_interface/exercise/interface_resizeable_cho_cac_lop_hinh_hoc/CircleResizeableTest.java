package ss07_abstract_class_and_interface.exercise.interface_resizeable_cho_cac_lop_hinh_hoc;

public class CircleResizeableTest {
    public static void main(String[] args) {
        Circle[] circles = new Circle[3];
        circles[0] = new CircleResizeable();
        circles[1] = new CircleResizeable(100);
        circles[2] = new CircleResizeable();
        circles[2].setRadius(1000);
        System.out.println("Pre - resizeable: ");
        for (Circle circle : circles) {
            System.out.println(circle + "\n\tArea of Circle: " + circle.getArea());
        }
        double percent = Math.random() * 100;
        System.out.println("Rate of change: " + percent + "%");
        System.out.println("After - resizeable: ");
        for (Circle circle : circles) {
            if (circle instanceof CircleResizeable) {
                Resizeable resizeable = (CircleResizeable) circle;
                resizeable.resize(percent);
                System.out.println(resizeable + "\n\tArea of Circle: " + circle.getArea());
            }
        }
    }
}
