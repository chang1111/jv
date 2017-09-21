package java04;

import java.util.Scanner;

public class ex04_11_구구단 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("시작 단수를 입력하세요 : ");
        int start = keyboard.nextInt();
        System.out.print("종료 단수를 입력하세요 : ");
        int end = keyboard.nextInt();
        keyboard.close();
        
        for (int i = start;i <= end;i = i + 1) {
            for (int j = 1;j <= 9;j = j + 1) {
                System.out.printf("%2d*%d=%3d", i, j, i * j);
                if (j == 9) {
                    System.out.print(".");
                }
                else {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}
