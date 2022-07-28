package ss07_abstract_class_and_interface.practice.interface_comparable_cho_cac_lop_hinh_hoc;

public class Shape {
    private String color = "green";
    private boolean filled = true;

    public Shape() {
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    @Override
    public String toString() {
        return "A Shape with color of " + color + (filled ? " and filled" : " and not filled");
    }
}
