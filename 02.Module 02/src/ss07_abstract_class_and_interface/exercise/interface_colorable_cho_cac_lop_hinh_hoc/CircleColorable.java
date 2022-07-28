package ss07_abstract_class_and_interface.exercise.interface_colorable_cho_cac_lop_hinh_hoc;

public class CircleColorable extends Circle implements Colorable {
    @Override
    public void howToColor(String color) {
        setColor(color);
        setFilled(true);
    }

    public CircleColorable() {
    }

    public CircleColorable(double radius) {
        super(radius);
    }

    public CircleColorable(double radius, String color, boolean filled) {
        super(radius, color, filled);
    }
}
