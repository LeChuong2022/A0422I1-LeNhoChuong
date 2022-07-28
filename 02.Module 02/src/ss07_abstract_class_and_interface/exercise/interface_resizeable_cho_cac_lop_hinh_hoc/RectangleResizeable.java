package ss07_abstract_class_and_interface.exercise.interface_resizeable_cho_cac_lop_hinh_hoc;

public class RectangleResizeable extends Rectangle implements Resizeable {
    @Override
    public void resize(double percent) {
        setWidth(getWidth() * percent / 100);
        setLength(getLength() * percent / 100);
    }

    public RectangleResizeable() {
    }

    public RectangleResizeable(double width, double length) {
        super(width, length);
    }

    public RectangleResizeable(double width, double length, String color, boolean filled) {
        super(width, length, color, filled);
    }
}
