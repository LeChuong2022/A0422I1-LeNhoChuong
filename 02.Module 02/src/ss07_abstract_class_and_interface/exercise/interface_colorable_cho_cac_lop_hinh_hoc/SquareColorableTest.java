package ss07_abstract_class_and_interface.exercise.interface_colorable_cho_cac_lop_hinh_hoc;

public class SquareColorableTest {
    public static void main(String[] args) {
        Square[] squares = new Square[3];
        squares[0] = new SquareColorable();
        squares[1] = new SquareColorable(10, "black", false);
        squares[2] = new SquareColorable(100);
        System.out.println("Pre filled: ");
        for (Square square : squares) {
            square.setFilled(false);
            System.out.println(square);
        }
        System.out.println("After filled: ");
        for (Square square : squares) {
            if (square instanceof SquareColorable) {
                Colorable colorable = (SquareColorable) square;
                colorable.howToColor("yellow");
                System.out.println(colorable);
            }
        }
    }
}
