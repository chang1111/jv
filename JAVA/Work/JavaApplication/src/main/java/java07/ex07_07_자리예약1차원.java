package java07;

import java.util.Scanner;

public class ex07_07_자리예약1차원 {
    
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int[] seat = new int[10];
        
        for(;;) {
            System.out.println("-------------------------------");
            for (int i = 1;i <= 10;i++){
                System.out.printf("%3d", i);
            }
            System.out.println();
            System.out.println("-------------------------------");
            for (int i = 0;i < 10;i++){
                System.out.printf("%3d", seat[i]);
            }
            System.out.println();
            System.out.println();
            System.out.print("원하시는 좌석번호를 입력하세요(종료는 -1) : ");
            int n = keyboard.nextInt();
            if (n == -1) {
                System.out.println("종료되었습니다.");
                break;
            }
            else if (seat[n - 1] == 1) {
                System.out.println("이미 예약된 자리입니다.");
            }
            else {
                seat[n - 1] = 1;
                System.out.println("예약되었습니다.");
            }

        }
        
        
    }
    
}
