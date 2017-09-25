package java06;

import java.util.Scanner;

public class ex06_03_사직연산메서드 {
    
    public static int Add(int x, int y) {
        int result = x + y;
        return result;
    }
    public static int Minus(int x, int y) {
        int result = x - y;
        return result;
    }
    public static int Mul(int x, int y) {
        int result = x * y;
        return result;
    }
    public static double Div(double x, double y) {
        double result = x / y;
        return result;
    }
    
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("First num : ");
        int n1 = keyboard.nextInt();
        System.out.print("Second num : ");
        int n2 = keyboard.nextInt();
        keyboard.close();
        
        System.out.println("Add : " + Add(n1, n2));
        
        System.out.println("Minus : " + Minus(n1, n2));
        
        System.out.println("Mul : " + Mul(n1, n2));
        
        System.out.println("Div : " + Div(n1, n2));
        
    }
    
}
