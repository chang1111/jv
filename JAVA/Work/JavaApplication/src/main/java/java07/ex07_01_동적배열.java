package java07;

import java.util.Scanner;

public class ex07_01_동적배열 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("만들고자 하는 배열 크기를 입력하시오 : ");
        int size = keyboard.nextInt();
        int a[] = new int[size];
        
        a[0] = 1;
        a[1] = 1;
        
        for (int i = 2;i < a.length;i++) {
            a[i] = a[i - 2] + a[i - 1];
        }
        for (int i = 0;i < a.length;i++) {
            System.out.println("a[" + i + "] = " + a[i]);
        }

        
    }
    
}
