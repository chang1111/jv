package test;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayList이용해서반의평균구하기 {
    
    public static void main(String[] args) {
        ArrayList<Integer> score = new ArrayList<Integer>();
        Scanner keyboard = new Scanner(System.in);
        System.out.print("학생수를 입력하시오 : ");
        int n = keyboard.nextInt();
        for (int i = 0;i < n;i++) {
            System.out.print("성적을 입력하시오 : ");
            int 점수 = keyboard.nextInt();
            score.add(new Integer(점수));
        }
        int sum = 0;
        for (int i = 0;i < score.size();i++) {
            sum = sum + (int)score.get(i);
        }
        System.out.println("평균은 : " + (double)sum/n);
    }
    
}
