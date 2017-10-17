package java14.st4shape;

public class Rectangle extends Shape {
    private int width;
    private int height;
    
    public Rectangle() {
        super();
        System.out.println("Rectangle()");
    }

    public Rectangle(int width, int height) {
        super();
        this.width = width;
        this.height = height;
        System.out.println("Rectangle(int width, int height)");
    }

    public Rectangle(int x, int y, String color) {
        super(x, y, color);
        System.out.println("Rectangle(int x, int y, String color)");
    }

    public Rectangle(int x, int y, String color, int width, int height) {
        super(x, y, color);
        this.width = width;
        this.height = height;
        System.out.println("Rectangle(int x, int y, String color, int width, int height)");
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
