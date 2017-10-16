package java14.st2hasa;

public class Circle {
    private int radius;
    private Point center;
    
    public Circle() {
        super();
    }
    public Circle(Point p, int radius) {
        center = p;
        this.radius = radius;
    }
    public Point getCenter() {
        return center;
    }
    public void setCenter(Point p) {
        center = p;
    }
    public int getRadius() {
        return radius;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }
    @Override
    public String toString() {
        return "Circle [center=" + center + ", radius=" + radius + "]";
    }
}
