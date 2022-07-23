package ss06_inheritance.exercise.ClassPoint2DAndClassPoint3D;

public class Point3D extends Point2D {
    private float z = 0.0f;

    Point3D() {
    }

    Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        setXY(x, y);
        this.z = z;
    }

    public float[] getXYZ() {
        float[] getXYZ = new float[3];
        getXYZ[0] = getX();
        getXYZ[1] = getY();
        getXYZ[2] = z;
        return getXYZ;
    }

    @Override
    public String toString() {
        return "Point 3D: \n\t x = " + getX() + "\n\t y = " + getY() + "\n\t z = " + getZ();
    }
}
