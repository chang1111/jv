package java17.st1shape;

public class ShapeTest3 {
    
    public static void main(String[] args) {
        Shape s = new Rectangle();
        Rectangle r = (Rectangle)s;
        r.x = 10;
        r.y = 10;
        r.width = 200;
        r.height = 200;
        System.out.println("s " + s);
        System.out.println("r " + r);
        
    }
    
}
