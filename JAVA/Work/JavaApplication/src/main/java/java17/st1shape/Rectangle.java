package java17.st1shape;

public class Rectangle extends Shape {
    public int width;
    public int height;
    
    public Rectangle() {
        super();
    }
    
    public Rectangle(int x, int y, int width, int height) {
        super(x, y);
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
    public Shape getShape() {
        return null;
    }
    public void draw() {
        System.out.println("Rectangle draw");
    }
}
