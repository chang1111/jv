package java07;

import java.util.Scanner;

public class ex07_06_숨겨진카드 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        for (;;) {
            int n = (int)(100 * Math.random());
            int min = 0, max = 99;
            System.out.println("수를 결정하였습니다. 맞추어 보세요.");
            for (int i = 1;;i++) {
                System.out.println(min + "~" + max);
                System.out.print(i + ">>");
                int input = keyboard.nextInt();
                if (input < n) {
                    System.out.println("더 높게");
                    if (input >= min) {
                        min = input + 1;
                    }
                }
                else if (input > n) {
                    System.out.println("더 낮게");
                    if (input <= max) {
                        max = input - 1;
                    }
                }
                else {
                    System.out.println("맞았습니다.");
                    break;
                }
            }
            char ch = ' ';
            for (;;) {
                System.out.print("다시하시겠습니까(y/n)>>");
                ch = keyboard.next().charAt(0);                
                if (ch == 'y' || ch == 'n') {
                    break;
                }
            }
            if (ch == 'n') {
                break;
            }
        }
    }
}
