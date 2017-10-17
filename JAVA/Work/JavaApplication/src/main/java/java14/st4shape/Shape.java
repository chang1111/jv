package java14.st4shape;

public class Shape {
    private int x;
    private int y;
    private String color = "";
    
    public Shape() {
        super();
        System.out.println("Shape()");
    }

    public Shape(int x, int y, String color) {
        super();
        this.x = x;
        this.y = y;
        this.color = color;
        System.out.println("Shape(int x, int y, String color)");
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Shape [x=" + x + ", y=" + y + ", color=" + color + "]";
    }
    
    
}
