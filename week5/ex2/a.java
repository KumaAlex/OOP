public class a {
    public static void main(String[] args) {
        Point point = new Point(10.2f, 123.0f);
        float[] a = point.getXY();
        for (int i = 0; i < 2; i++ ){
            System.out.println(a[i]);
        }
        System.out.println(point.toString());

        MovablePoint po = new MovablePoint(1.0f, 1.0f, 2.0f, 2.0f);
        System.out.println(po.getX());
        po.move();
        System.out.println(po.getX());
        po.move();
        po.move();
        po.move();
        System.out.println(po.getX());
    }
}

class Point {
    protected float x = 0.0f;
    protected float y = 0.0f;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Point() {}

    public float getX() {
        return(this.x);
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return(this.y);
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float[] getXY() {
        float a[] = {this.x, this.y};
        return(a);
    }

    public String toString() {
        return("(" + this.x + "," + this.y + ")");
    }
}

class MovablePoint extends Point {
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint() {}

    public float getXSpeed() {
        return(this.xSpeed);
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return(this.ySpeed);
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        float[] a = {this.xSpeed, this.ySpeed};
        return(a);
    }

    @Override

    public String toString() {
        return(super.toString() + ",speed=(" + this.xSpeed + "," + ySpeed + ")");
    }

    public MovablePoint move() {
        this.setX(this.getX() + this.xSpeed);
        this.setY(this.getY() + this.ySpeed);
        return(this);
    }
}