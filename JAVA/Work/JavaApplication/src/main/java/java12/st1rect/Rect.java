package java12.st1rect;

public class Rect {
    private double width;
    private double height;
    
    public Rect() {
        super();
    } // constructor
    
    public Rect(double width, double height) {
        super();
        this.width = width;
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    } // set width
    public void setHeight(double height) {
        this.height = height;
    } // set height
    
    public double getWidth() {
        return width;
    } // get width
    public double getHeight() {
        return height;
    } // get height
    
    public double area() {
        return width * height;
    } // get area
    
    public double perimeter() {
        return 2 * (width + height);
    } // get perimeter

    @Override
    public String toString() {
        return "Rect [width=" + width + ", height=" + height + "]";
    }
    
} // class Rect
