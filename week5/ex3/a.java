public class a {
    public static void main (String[] args) {
        Shape shape = new Shape("blue", true);
        System.out.println(shape.getColor());
        shape.setColor("yellow");
        System.out.println(shape.getColor());
        System.out.println(shape.toString());

        Circle circle = new Circle(4.4, "red", false);
        circle.setRadius(5.5);
        System.out.println(circle.getRadius());
        System.out.println(circle.getArea());

        Rectangle rect = new Rectangle();
        System.out.println(rect.toString());

        Square sq = new Square(5.0, "pink", false);
        sq.setSide(6.0);
        System.out.println(sq.toString());
    }
}

class Shape {
    protected String color = "red";
    protected boolean filled = true;

    public Shape() {}

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return(this.color);
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return(this.filled);
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public String toString() {
        return("Shape[color=" + this.color + ",filled=" + this.filled + "]");
    }
}

class Circle extends Shape {
    private double radius = 1.0;

    public Circle() {}

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return(this.radius);
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return(3.14*this.radius*this.radius);
    }

    public double getPerimeter() {
        return(2*3.14*this.radius);
    }

    @Override

    public String toString() {
        return("Circle[" + super.toString() + ",radius=" + this.radius + "]");
    }
}

class Rectangle extends Shape {
    protected double width = 1.0;
    protected double length = 1.0;
        
    public Rectangle() {}

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return(this.width);
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return(this.length);
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return(this.width*this.length);
    }

    public double getPerimeter() {
        return((this.length + this.width)*2);
    }

    @Override

    public String toString() {
        return("Rectangle[" + super.toString() + ",width=" + this.width + ",length=" + this.length + "]");
    }
}

class Square extends Rectangle {
    public Square() {}

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return(super.getWidth());
    }

    public void setSide(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    @Override

    public void setWidth(double side) {
        this.setSide(side);
    }

    public void setLength(double side) {
        this.setSide(side);
    }

    public String toString() {
        return("Square[" + super.toString() + "]");
    }
}
