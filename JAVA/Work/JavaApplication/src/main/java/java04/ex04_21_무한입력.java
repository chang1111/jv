package java04;

import java.util.Scanner;

public class ex04_21_무한입력 {
    
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        for (;true;) {
            System.out.print("정수를 입력하세요 : ");
            int n = keyboard.nextInt();
            if (n >= 0) {
                System.out.println("입력한 값은 " + n + "입니다.");
            }
            else {
                System.out.println("정상 종료합니다.");
                break;
            }
        }
        keyboard.close();
        
    }
    
}
