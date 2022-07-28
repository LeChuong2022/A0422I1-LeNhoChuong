package ss07_abstract_class_and_interface.exercise.interface_resizeable_cho_cac_lop_hinh_hoc;

public class SquareResizeableTest {
    public static void main(String[] args) {
        Square[] squares = new Square[3];
        squares[0] = new SquareResizeable();
        squares[1] = new SquareResizeable(10);
        squares[2] = new SquareResizeable();
        squares[2].setSide(100);
        System.out.println("Pre - resizeable: ");
        for (Square square : squares) {
            System.out.println(square + "\n\tArea of rectangle: " + square.getArea());
        }
        double percent = Math.random() * 100;
        System.out.println("Rate of change: " + percent + "%");
        System.out.println("After - resizeable: ");
        for (Square square : squares) {
            if (square instanceof SquareResizeable) {
                Resizeable resizeable = (SquareResizeable) square;
                resizeable.resize(percent);
                System.out.println(resizeable + "\n\tArea of rectangle: " + square.getArea());
            }
        }
    }
}
