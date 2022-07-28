package ss07_abstract_class_and_interface.exercise.interface_resizeable_cho_cac_lop_hinh_hoc;

public class ShapeResizeableTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new CircleResizeable(10);
        shapes[1] = new RectangleResizeable(100, 200);
        shapes[2] = new SquareResizeable(1000);
        System.out.println("Pre - resizeable: ");
        for (Shape shape : shapes) {
            if (shape instanceof CircleResizeable) {
                System.out.println(shape + "\n\tArea of circle: " + ((CircleResizeable) shape).getArea());
            } else if (shape instanceof RectangleResizeable) {
                System.out.println(shape + "\n\tArea of rectangle: " + ((RectangleResizeable) shape).getArea());
            } else if (shape instanceof SquareResizeable) {
                System.out.println(shape + "\n\tArea of square: " + ((SquareResizeable) shape).getArea());
            }
        }
        double percent = Math.random() * 100;
        System.out.println("Rate of changed: " + percent + "%");
        System.out.println("After - resizeable: ");
        for (Shape shape : shapes) {
            Resizeable resizeable = null;
            if (shape instanceof CircleResizeable) {
                resizeable = (CircleResizeable) shape;
                resizeable.resize(percent);
                System.out.println(resizeable + "\n\tArea of circle: " + ((CircleResizeable) shape).getArea());
            } else if (shape instanceof RectangleResizeable) {
                resizeable = (RectangleResizeable) shape;
                resizeable.resize(percent);
                System.out.println(resizeable + "\n\tArea of rectangle: " + ((RectangleResizeable) shape).getArea());
            } else if (shape instanceof SquareResizeable) {
                resizeable = (SquareResizeable) shape;
                resizeable.resize(percent);
                System.out.println(resizeable + "\n\tArea of square: " + ((SquareResizeable) shape).getArea());
            }
        }
    }
}
