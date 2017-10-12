package java12.st1rect;

import java12.st1rect.Rect;

import java.util.Scanner;

public class RectTest {
    
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("가로 : ");
        double width = keyboard.nextDouble();
        System.out.print("세로 : ");
        double height = keyboard.nextDouble();
        
        Rect rect = new Rect();
        rect.setWidth(width);
        rect.setHeight(height);
        
        double area = rect.area();
        double perimeter = rect.perimeter();
        
        System.out.println("사각형의 넓이 : " + area);
        System.out.println("사각형의 둘레 : " + perimeter);
        System.out.println(rect.toString());
        
    }
    
}
