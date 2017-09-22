package java04;

import java.util.Scanner;

public class ex04_14_무한구구단 {
    
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        for (;true;) {
            System.out.print("시작단 : ");
            int n1 = keyboard.nextInt();
            System.out.print("종료단 : ");
            int n2 = keyboard.nextInt();
            
            if (n1 > n2) {
                int t = n1;
                n1 = n2;
                n2 = t;
            }
            
            if (n1 == 0||n2 == 0) {
                System.out.println("종료합니다.");
                break;
            }
            
            for (int i = n1;i <= n2;i = i + 1) {
                for (int j = 1;j <= 9;j = j + 1) {
                    System.out.printf("%2d*%d=%3d", i, j, i * j);
                    if (j == 9) {
                        System.out.println(".");
                    }
                    else {
                        System.out.print(", ");
                    }
                }
            }
        }
        
    }
    
}
