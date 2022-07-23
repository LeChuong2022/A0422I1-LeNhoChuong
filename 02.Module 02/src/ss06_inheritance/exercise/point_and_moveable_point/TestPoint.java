package ss06_inheritance.exercise.point_and_moveable_point;

public class TestPoint {
    public static void main(String[] args) {
        Point point = new Point();
        System.out.println(point);
        Point point1 = new Point(1.0f, 1.1f);
        System.out.println(point1);
        point1.setX(2.0f);
        point1.setY(2.1f);
        System.out.println("\t" + point1.getX() + "\t" + point1.getY());
        point1.setXY(3.0f, 3.1f);
        for (int i = 0; i < point1.getXY().length; i++) {
            System.out.println(point1.getXY()[i]);
        }
    }
}
