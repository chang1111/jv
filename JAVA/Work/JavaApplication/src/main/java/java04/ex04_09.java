package java04;

import java.util.Scanner;

public class ex04_09 {
    
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int n = keyboard.nextInt();
        keyboard.close();
        int sum = 0, sum0 = 0;
        for (int i = 1;i <= n;i = i + 1) {
            sum0 = 0;
            for (int j = 1;j <= i; j = j + 1) {
                sum0 = sum0 + j;
            }
            sum = sum + sum0;
        }
        System.out.println(sum);
        
    }
    
}
