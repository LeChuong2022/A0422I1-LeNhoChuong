package ss07_abstract_class_and_interface.exercise.interface_colorable_cho_cac_lop_hinh_hoc;

public class ShapeColorableTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new CircleColorable();
        shapes[1] = new RectangleColorable();
        shapes[2] = new SquareColorable();
        System.out.println("Pre - filled: ");
        for (Shape shape : shapes) {
            shape.setFilled(false);
            System.out.println(shape);
        }
        System.out.println("After - filled: ");
        for (Shape shape : shapes) {
            Colorable colorable = null;
            if (shape instanceof CircleColorable) {
                colorable = (CircleColorable) shape;
            } else if (shape instanceof RectangleColorable) {
                colorable = (RectangleColorable) shape;
            } else if (shape instanceof SquareColorable) {
                colorable = (SquareColorable) shape;
            }
            colorable.howToColor("brown");
            System.out.println(colorable);
        }
    }
}
