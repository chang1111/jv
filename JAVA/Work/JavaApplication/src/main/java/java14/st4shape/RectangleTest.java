package java14.st4shape;

public class RectangleTest {
    
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(1, 1, "black");
        Rectangle r2 = new Rectangle();
        Rectangle r3 = new Rectangle(100, 200);
        Rectangle r4 = new Rectangle(1, 1, "black", 100, 200);
        
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        System.out.println(r4);
        
    }
    
}
