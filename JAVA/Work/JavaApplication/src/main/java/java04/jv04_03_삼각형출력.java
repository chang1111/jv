package java04;

public class jv04_03_삼각형출력 {
    
    public static void main(String[] args) {
        for (int i = 1;i <= 9;i = i + 1) {
            for (int j = 1;j <= i; j = j + 1) {
                System.out.print('*');
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 1;i <= 9;i = i + 1) {
            for (int j = 1;j <= 9;j = j + 1) {
                if (j >= i) {
                    System.out.print('*');
                }
                else {
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 1;i <= 9;i = i + 1) {
            for (int j = -8;j <= 8;j = j + 1) {
                if (-i < j && j < i) {
                    System.out.print('*');
                }
                else {
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
    }
    
}
