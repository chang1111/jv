package test;

import java.util.Scanner;

public class tw02_01_면적구하기 {
    
    public static void main(String[] args) {
        double w = 0, h = 0;
        double area = 0, perimeter = 0;
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("가로의 길이를 입력하세요 : ");
        w = keyboard.nextDouble();
        System.out.print("세로의 길이를 입력하세요 : ");
        h = keyboard.nextDouble();
        keyboard.close();
        
        area = w * h;
        perimeter = 2 * (w + h);
        
        System.out.println("사각형의 넓이 : " + area);
        System.out.println("사각형의 둘레 : " + perimeter);
    }
    
}
