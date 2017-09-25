package java05;

public class ex05_11_369게임 {

    public static void main(String[] args) {
        for (int i = 1;i <= 1000000;i++) {
            int n = i, count = 0;
            for (;;) {
                if (n % 10 % 3 == 0 && n % 10 != 0) {
                    count++;
                }
                if (n / 10 != 0) {
                    n = n / 10;
                }
                else {
                    break;
                }
            }
            if (count == 1) {
                System.out.println(i + " 박수 한번");
            }
            else if (count == 2) {
                System.out.println(i + " 박수 두번");
            }
            else if (count == 3) {
                System.out.println(i + " 박수 세번");
            }
            else if (count == 4) {
                System.out.println(i + " 박수 네번");
            }
            else if (count == 5) {
                System.out.println(i + " 박수 다섯번");
            }
            else if (count == 6) {
                System.out.println(i + " 박수 여섯번");
            }
        }
    }
}