package java18;

import java.util.Random;
import java.util.Scanner;

public class jv18_03_Random {
    
    public static void main(String[] args) {
        
        // 난수(임의의 수) 만들기
        // new Random().nextDouble()는 0부터 1사이의 실수값
        Random rand = new Random();
        double rand1 = rand.nextDouble();
        System.out.println(rand1);
        System.out.println("----------------------");
        
        // 난수를 이용해서 0부터 2사이의 값을 만드시오
        double rand3 = rand.nextDouble() * 2;
        System.out.println(rand3);
        System.out.println("----------------------");
        
        // 문제 1. 난수를 이용해서 1부터 3사이의 값을 만드시오. 실수
        double rand4 = rand.nextDouble() * 2 + 1;
        System.out.println(rand4);
        System.out.println("----------------------");
        
        // 문제 2. 0 이상 10 미만의 난수 5개를 생성해서 출력하시오. 실수
        double[] rand5 = new double[5];
        for (double i:rand5) {
            i = rand.nextDouble() * 10;
            System.out.println(i);
        }
        System.out.println("----------------------");
        
        // 문제 3. 사용자로 부터 최대 정수 A와 최소 정수 B를 입력 받는다.
        // 그리고 A와 B 사이에 존재하는 난수 10개를 생성해서 출력하시오. 정수
        Scanner keyboard = new Scanner(System.in);
        System.out.print("최대정수 A = ");
        int a = keyboard.nextInt();
        System.out.print("최소정수 B = ");
        int b = keyboard.nextInt();
        int[] rand6 = new int[10];
        for (int i:rand6) {
            i = (int)(rand.nextDouble() * (a - b + 1) + b);
            System.out.println(i);
        }
    }
    
}
