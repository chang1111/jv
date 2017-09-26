package java06;

import java.util.Scanner;

public class ex06_02_add {
    
    public static int add(int x, int y) {
        return x + y;
    }
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("두 정수를 입력하세요 : ");
        int n1 = keyboard.nextInt();
        int n2 = keyboard.nextInt();
        int result = add(n1, n2);
        System.out.println("합 = " + result);
    }
    
}
