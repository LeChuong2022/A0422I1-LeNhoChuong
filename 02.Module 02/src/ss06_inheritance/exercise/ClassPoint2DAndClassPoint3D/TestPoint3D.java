package ss06_inheritance.exercise.ClassPoint2DAndClassPoint3D;

public class TestPoint3D {
    public static void main(String[] args) {
        Point3D point3D = new Point3D();
        System.out.println(point3D);
        Point3D point3D1 = new Point3D(10.0f, 11.0f, 12.0f);
        System.out.println(point3D1);
        point3D1.setXYZ(13.0f, 14.0f, 15.0f);
        System.out.println(point3D1);
        point3D1.setXY(17.0f, 16.0f);
        System.out.println(point3D1);
        point3D1.setX(18.0f);
        System.out.println(point3D1);
        point3D1.setY(19.0f);
        System.out.println(point3D1);
        point3D1.setZ(20.0f);
        System.out.println(point3D1);
        for (int i = 0; i < point3D1.getXYZ().length; i++) {
            System.out.println(point3D1.getXYZ()[i]);
        }
        for (int i = 0; i < point3D1.getXY().length; i++) {
            System.out.println("\t" + point3D1.getXY()[i]);
        }
        System.out.println("\t" + point3D1.getX() + "\t" + point3D1.getY() + "\t" + point3D1.getZ());
    }
}
