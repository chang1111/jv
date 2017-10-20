package java17.st1shape;

public class Triangle extends Shape {
    public int base;
    public int height;
    
    public Triangle() {
        super();
    }

    public Triangle(int x, int y, int base, int height) {
        super(x, y);
        this.base = base;
        this.height = height;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Triangle [base=" + base + ", height=" + height + ", toString()="
                + super.toString() + "]";
    }

    public Shape getShape() {
        return null;
    }
    
    public void draw() {
        System.out.println("Triangle draw");
    }
}
