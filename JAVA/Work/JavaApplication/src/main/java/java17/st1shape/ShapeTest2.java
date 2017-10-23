package java17.st1shape;

public class ShapeTest2 {
    
    public static void main(String[] args) {
        
        //클래스 상향 형변환
        Shape s = null;
        Rectangle r = new Rectangle();
        r.x = 0;
        r.y = 0;
        r.width = 100;
        r.height = 100;
        System.out.println("r " + r);
        
        s = r;
        
        System.out.println("s " + s);
        
        s.x = 10;
        s.y = 10;
//        s.width = 100;
//        s.height = 100;
        System.out.println("s " + s);
        System.out.println("r " + r);
    }
}
