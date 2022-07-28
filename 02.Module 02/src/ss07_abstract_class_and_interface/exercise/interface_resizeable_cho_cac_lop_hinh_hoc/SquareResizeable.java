package ss07_abstract_class_and_interface.exercise.interface_resizeable_cho_cac_lop_hinh_hoc;

public class SquareResizeable extends Square implements Resizeable {
    @Override
    public void resize(double percent) {
        setSide(getSide() * percent / 100);
    }

    public SquareResizeable() {
    }

    public SquareResizeable(double side) {
        super(side);
    }

    public SquareResizeable(double size, String color, boolean filled) {
        super(size, color, filled);
    }
}
