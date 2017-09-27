package java07;

import java.util.Scanner;

public class jv07_03_반평균구하기2 {
    
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("배열의 크기를 입력하시오 : ");
        int size = keyboard.nextInt();
        int[] score = new int[size];
        for (int i = 0;i < score.length;i++) {
            System.out.print("숫자를 입력하시오 : ");
            score[i] = keyboard.nextInt();
        }
        
        System.out.print("배열의 값은 : ");
        
        for (int i = 0;i < score.length-1;i++) {
            System.out.print(score[i] + ", ");
        }
        System.out.println(score[score.length-1]);
        
    }
    
}
