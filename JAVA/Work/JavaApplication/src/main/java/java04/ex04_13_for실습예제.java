package java04;

public class ex04_13_for실습예제 {
    
    public static void main(String[] args) {
        for (int i = 1;i <= 9;i = i + 1) {
            System.out.print("2*" + i + "=" + (2 * i));
            if (i != 9) {
                System.out.print(", ");
            }
            else {
                System.out.println(".");
            }
        }
    }
    
}
