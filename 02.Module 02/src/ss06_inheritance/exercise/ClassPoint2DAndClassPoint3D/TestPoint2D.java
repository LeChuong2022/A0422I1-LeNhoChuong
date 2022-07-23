package ss06_inheritance.exercise.ClassPoint2DAndClassPoint3D;

public class TestPoint2D {
    public static void main(String[] args) {
        Point2D point2D = new Point2D();
        System.out.println(point2D);
        Point2D point2D1 = new Point2D(10.0f, 10.0f);
        System.out.println(point2D1);
        point2D1.setXY(20.0f, 21.0f);
        System.out.println(point2D1);
        for (int i = 0; i < point2D1.getXY().length; i++) {
            System.out.println(point2D1.getXY()[i]);
        }
        point2D1.setX(30.0f);
        point2D1.setY(31.0f);
        for (int i = 0; i < point2D1.getXY().length; i++) {
            System.out.println(point2D1.getXY()[i]);
        }
        System.out.println("\t" + point2D1.getX() + "\t" + point2D1.getY());
    }
}
