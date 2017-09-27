package java07;

import java.util.Scanner;

public class ex07_03_배열로최대최소구하기2 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int[] input = new int[10];
        System.out.print("INPUT : ");
        for (int i = 0;i < 10;i++) {
            input[i] = keyboard.nextInt();
        }
        System.out.print("배열 정렬 전 : ");
        for (int i = 0;i < 10;i++) {
            System.out.print(input[i]);
            if (i == 9) {
                System.out.println();
            }
            else {
                System.out.print(", ");
            }
        }
        for (int i = 0;i < 9;i++) {
            for (int j = 0;j < 9 - i;j++) {
                if (input[j] > input[j+1]) {
                    int temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                }
            }
        }
        System.out.print("배열 정렬 후 : ");
        for (int i = 0;i < 10;i++) {
            System.out.print(input[i]);
            if (i == 9) {
                System.out.println();
            }
            else {
                System.out.print(", ");
            }
        }
        int min = input[0], max = input[0];
        for (int i = 1;i < 10;i++) {
            if (min > input[i]) {
                min = input[i];
            }
            if (max < input[i]) {
                max = input[i];
            }
        }
        System.out.println("최소값 : " + min + "\n최대값 : " + max);
        
    }
}
