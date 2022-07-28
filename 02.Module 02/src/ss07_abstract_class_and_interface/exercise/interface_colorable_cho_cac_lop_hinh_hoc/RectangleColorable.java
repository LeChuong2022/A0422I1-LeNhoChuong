package ss07_abstract_class_and_interface.exercise.interface_colorable_cho_cac_lop_hinh_hoc;

public class RectangleColorable extends Rectangle implements Colorable {
    @Override
    public void howToColor(String color) {
        setColor(color);
        setFilled(true);
    }

    public RectangleColorable() {
    }

    public RectangleColorable(double width, double length) {
        super(width, length);
    }

    public RectangleColorable(double width, double length, String color, boolean filled) {
        super(width, length, color, filled);
    }
}
