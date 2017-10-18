package java14.st11exercise;

public class Rectangle extends Shape {
    private int width;
    private int height;
    
    public Rectangle() {
        super();
    }
    public Rectangle(String color, Point pt, int width, int height) {
        super(color, pt);
        this.width = width;
        this.height = height;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    @Override
    public String toString() {
        return "Rectangle [width=" + width + ", height=" + height
                + ", toString()=" + super.toString() + "]";
    }
    
}
