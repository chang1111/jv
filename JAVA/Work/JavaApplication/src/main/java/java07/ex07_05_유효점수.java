package java07;

import java.util.Scanner;

public class ex07_05_유효점수 {
    
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("심사위원의 수를 입력하시오 : ");
        int size = keyboard.nextInt();
        int[] score = new int[size];
        System.out.print("5명 심사위원의 점수 입력 : ");
        for (int i = 0;i < size;i++) {
            score[i] = keyboard.nextInt();
        }
        for (int i = 0;i < size - 1;i++) {
            for (int j = 0;j < size - 1 - i;j++) {
                if (score[j] > score[j+1]){
                    int temp = score[j];
                    score[j] = score[j+1];
                    score[j+1] = temp;
                }
            }
        }
        System.out.print("유효점수 : ");
        int sum = 0;
        for (int i = 1;i < size - 1;i++) {
            sum = sum + score[i];
            System.out.print(score[i]);
            if (i == size - 2) {
                System.out.println();
            }
            else {
                System.out.print(" ");
            }
        }
        System.out.println("합계 : " + sum);
        System.out.printf("평균 : %.2f\n", (double)sum/(size-2));
        
    }
    
}
