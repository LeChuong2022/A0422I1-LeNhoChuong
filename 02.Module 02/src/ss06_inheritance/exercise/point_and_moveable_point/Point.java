package ss06_inheritance.exercise.point_and_moveable_point;

public class Point {
    private float x = 0.0f;
    private float y = 0.0f;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float[] getXY() {
        float[] getXY = new float[2];
        getXY[0] = x;
        getXY[1] = y;
        return getXY;
    }

    @Override
    public String toString() {
        return "\t(x,y) = (" + getXY()[0] + ", " + getXY()[1] + ")";
    }
}
