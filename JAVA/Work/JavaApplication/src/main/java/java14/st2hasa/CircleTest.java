package java14.st2hasa;

public class CircleTest {
    
    public static void main(String[] args) {
        
        Point p = new Point();
        Circle c1 = new Circle();
        
        p.setX(25);
        p.setY(78);
        c1.setCenter(p);
        c1.setRadius(10);
        System.out.println(c1);
        
        Circle c2 = new Circle();
        c2.setRadius(10);
        Point center = new Point(25,78);
        c2.setCenter(center);
        System.out.println(c2);
        
        Circle c3 = new Circle(new Point(25,78), 10);
        System.out.println(c3);
    }
    
}
