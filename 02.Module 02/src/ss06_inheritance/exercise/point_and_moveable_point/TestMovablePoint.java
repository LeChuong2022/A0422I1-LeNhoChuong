package ss06_inheritance.exercise.point_and_moveable_point;

public class TestMovablePoint {
    public static void main(String[] args) {
        MovablePoint movablePoint = new MovablePoint();
        System.out.println(movablePoint);
        MovablePoint movablePoint1 = new MovablePoint(1.2f, 1.3f);
        System.out.println(movablePoint1);
        MovablePoint movablePoint2 = new MovablePoint(2.0f, 2.1f, 2.2f, 2.3f);
        System.out.println(movablePoint2);
        movablePoint2.setX(3.0f);
        movablePoint2.setY(3.1f);
        movablePoint2.setXSpeed(3.2f);
        movablePoint2.setYSpeed(3.3f);
        System.out.println("\t" + movablePoint2.getX() + "\t" + movablePoint2.getY() +
                "\t" + movablePoint2.getXSpeed() + "\t" + movablePoint2.getYSpeed());
        movablePoint2.setXY(4.0f, 4.1f);
        movablePoint2.setSpeed(4.2f, 4.3f);
        System.out.println("\t" + movablePoint2.getXY()[0] + "\t" + movablePoint2.getXY()[1] +
                "\t" + movablePoint2.getSpeed()[0] + "\t" + movablePoint2.getSpeed()[1]);
        System.out.println("\t" + movablePoint2.move().getX() + "\t" + movablePoint2.move().getY() +
                "\t" + movablePoint2.move().getXSpeed() + "\t" + movablePoint2.move().getYSpeed());
        System.out.println(movablePoint2);
        MovablePoint movablePoint3 = movablePoint2.move();
        System.out.println(movablePoint3);
    }
}
