package java07;

import java.util.Scanner;
import java.util.Arrays;

public class ex07_05_유효점수 {
    
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("심사위원의 수를 입력하시오 : ");
        int size = keyboard.nextInt();
        int[] score = new int[size];
        System.out.print("5명 심사위원의 점수 입력 : ");
        for (int i = 0;i < score.length;i++) {
            score[i] = keyboard.nextInt();
        }
        
        Arrays.sort(score);
        
        System.out.print("유효점수 : ");
        int sum = 0;
        for (int i = 1;i < score.length - 1;i++) {
            sum = sum + score[i];
            System.out.print(score[i]);
            if (i == score.length - 2) {
                System.out.println();
            }
            else {
                System.out.print(" ");
            }
        }
        System.out.println("합계 : " + sum);
        System.out.printf("평균 : %.2f\n", (double)sum/(score.length-2));
        
    }
    
}
