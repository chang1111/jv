package test;

public class tw02_01 {
    public static void main(String[] args) {
        double w = 10, h = 5;
        double area = 0, perimeter = 0;
        
        area = w * h;
        perimeter = 2 * (w + h);
        
        System.out.println("사각형의 넓이 : " + area);
        System.out.println("사각형의 둘레 : " + perimeter);
    }
}
