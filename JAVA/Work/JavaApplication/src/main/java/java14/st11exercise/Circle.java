package java14.st11exercise;

public class Circle extends Shape {
    private int radius;

    public Circle() {
        super();
    }

    public Circle(String color, Point pt, int radius) {
        super(color, pt);
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
    
}
