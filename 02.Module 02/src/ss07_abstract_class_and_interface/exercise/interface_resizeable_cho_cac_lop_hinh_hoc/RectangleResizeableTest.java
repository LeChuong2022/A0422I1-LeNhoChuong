package ss07_abstract_class_and_interface.exercise.interface_resizeable_cho_cac_lop_hinh_hoc;

public class RectangleResizeableTest {
    public static void main(String[] args) {
        Rectangle[] rectangles = new Rectangle[3];
        rectangles[0] = new RectangleResizeable();
        rectangles[1] = new RectangleResizeable(10, 100);
        rectangles[2] = new RectangleResizeable();
        rectangles[2].setWidth(100);
        rectangles[2].setLength(1000);
        System.out.println("Pre - resizeable: ");
        for (Rectangle rectangle : rectangles) {
            System.out.println(rectangle + "\n\tArea of rectangle: " + rectangle.getArea());
        }
        double percent = Math.random() * 100;
        System.out.println("Rate of change: " + percent + "%");
        System.out.println("After - resizeable: ");
        for (Rectangle rectangle : rectangles) {
            if (rectangle instanceof RectangleResizeable) {
                Resizeable resizeable = (RectangleResizeable) rectangle;
                resizeable.resize(percent);
                System.out.println(resizeable + "\n\tArea of rectangle: " + rectangle.getArea());
            }
        }
    }
}
