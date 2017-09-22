package java04;

public class ex04_09 {
    
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1;i <= 10;i = i + 1) {
            int sum0 = 0;
            for (int j = 1;j <= i; j = j + 1) {
                sum0 = sum0 + j;
            }
            sum = sum + sum0;
        }
        System.out.println("결과값은 : " + sum);
        
    }
    
}
