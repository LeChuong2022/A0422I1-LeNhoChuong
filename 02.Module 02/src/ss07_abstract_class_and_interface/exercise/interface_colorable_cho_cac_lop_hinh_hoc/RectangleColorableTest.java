package ss07_abstract_class_and_interface.exercise.interface_colorable_cho_cac_lop_hinh_hoc;

public class RectangleColorableTest {
    public static void main(String[] args) {
        Rectangle[] rectangles = new Rectangle[3];
        rectangles[0] = new RectangleColorable();
        rectangles[1] = new RectangleColorable(10.0, 20.0);
        rectangles[2] = new RectangleColorable(100.0, 200, "cyan", false);
        System.out.println("Pre - filled: ");
        for (Rectangle rectangle : rectangles) {
            rectangle.setFilled(false);
            System.out.println(rectangle);
        }
        System.out.println("After - filled");
        for (Rectangle rectangle : rectangles) {
            if (rectangle instanceof RectangleColorable) {
                Colorable colorable = (RectangleColorable) rectangle;
                colorable.howToColor("black");
                System.out.println(rectangle);
            }
        }
    }
}
