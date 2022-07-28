package ss07_abstract_class_and_interface.exercise.interface_resizeable_cho_cac_lop_hinh_hoc;

public class CircleResizeable extends Circle implements Resizeable {
    @Override
    public void resize(double percent) {
        setRadius(percent / 100 * getRadius());
    }

    public CircleResizeable() {
    }

    public CircleResizeable(double radius) {
        super(radius);
    }

    public CircleResizeable(double radius, String color, boolean filled) {
        super(radius, color, filled);
    }
}
