package ss07_abstract_class_and_interface.exercise.interface_colorable_cho_cac_lop_hinh_hoc;

public class SquareColorable extends Square implements Colorable {
    @Override
    public void howToColor(String color) {
        setColor(color);
        setFilled(true);
    }

    public SquareColorable() {
    }

    public SquareColorable(double side) {
        super(side);
    }

    public SquareColorable(double side, String color, boolean filled) {
        super(side, color, filled);
    }
}
