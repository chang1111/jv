package java14.st11exercise;

public class PatternTest {
    
    public static void main(String[] args) {
        
        Shape s = new Shape("red", new Point(-2,-5));
        
        Rectangle r = new Rectangle("black", new Point(0,0), 5, 5);
        
        Circle c = new Circle("blue", new Point(5,10), 10);
        
        System.out.println(s);
        System.out.println(r);
        System.out.println(c);
        
    }
    
}
