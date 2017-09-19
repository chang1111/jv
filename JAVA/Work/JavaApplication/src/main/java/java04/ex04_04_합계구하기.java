package java04;

import java.util.Scanner;

public class ex04_04_합계구하기 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("시작값을 입력하세요. ");
        int start = keyboard.nextInt();
        System.out.print("종료값을 입력하세요. ");
        int end = keyboard.nextInt();
        keyboard.close();
        
        int sum = 0;
        
        if (start > end) {
            int t = start;
            start = end;
            end = t;
        }
        
        for (int i = start;i <= end;i = i + 1) {
            sum = sum + i;
        }
        
        System.out.println(start + "부터 " + end + "까지의 합계는 " + sum + "입니다");
        
        sum = 0;
        
        if (start < end) {
            for (int i = start;i <= end;i = i + 1) {
                sum = sum + i;
            }
            System.out.println(start + "부터 " + end + "까지의 합계는 " + sum + "입니다");
        }
        else {
            for (int i = end;i <= start;i = i + 1) {
                sum = sum + i;
            }
            System.out.println(end + "부터 " + start + "까지의 합계는 " + sum + "입니다");
        
        }
        
    }
    
}
