package java02;

import java.util.Scanner;

public class ex02_01_면적구하기 {
    
    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in);
        
        int w = 0, h = 0;
        int area, perimeter;
        
        w = keyboard.nextInt();
        h = keyboard.nextInt();
        keyboard.close();
        
        area = w * h;
        perimeter = 2 * (w + h);
        
        System.out.println("사각형의 넓이 : " + area);
        System.out.println("사각형의 둘레 : " + perimeter);
    }
    
}
