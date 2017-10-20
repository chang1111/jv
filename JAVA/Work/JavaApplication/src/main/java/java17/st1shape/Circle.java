package java17.st1shape;

public class Circle extends Shape {
    public int radius;
    
    public Circle() {
        super();
    }

    public Circle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle [radius=" + radius + ", toString()=" + super.toString()
                + "]";
    }

    public Shape getShape() {
        return null;
    }
    
    public void draw() {
        System.out.println("Circle draw");
    }
}
