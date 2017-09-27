package java07;

import java.util.Scanner;

public class jv07_03_반평균구하기3 {
    
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("학생수를 입력하시오 : ");
        int size = keyboard.nextInt();
        int[] score = new int[size];
        for (int i = 0;i < score.length;i++) {
            System.out.print("숫자를 입력하시오 : ");
            score[i] = keyboard.nextInt();
        }
        
        int sum = 0;
        for (int i = 0;i < score.length;i++) {
            sum = sum + score[i];
        }
        System.out.println("합계 : " + sum);
        System.out.printf("평균 : %.2f\n", ((double)sum / size));
        
    }
    
}
