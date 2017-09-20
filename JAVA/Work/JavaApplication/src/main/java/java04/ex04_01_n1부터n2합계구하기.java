package java04;

import java.util.Scanner;

public class ex04_01_n1부터n2합계구하기 {
    
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("정수를 입력하세요 : ");
        int n1 = keyboard.nextInt();
        int n2 = keyboard.nextInt();
        keyboard.close();
        int sum = 0;
        
        for (int i = n1;i <= n2;i = i + 1) {
            sum = sum + i;
            System.out.print(i);
            if (i != n2) {
                System.out.print('+');
            }
            else{
                System.out.print('=');
            }
        }
        System.out.println(sum);
        
    }
    
}
