package test;

import java.util.Scanner;

public class tw01_02 {
    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("정수를 입력하세요 : ");
        int i = keyboard.nextInt();
        System.out.println(i);
        
        System.out.print("문자열을 입력하세요 : ");
        String s = keyboard.next();
        System.out.println(s);
        
        keyboard.close();
    }
}
