package java06;

public class jv06_04_어떻게메서드를만드는가 {

    public static void main(String[] args) {
        int sum = getSum(1, 10);
        System.out.println("1부터 10까지 합계 = " + sum);

        int sum2 = 0;
        for (int i = 1;i <= 100;i = i + 1) {
            sum2 = sum2 + i;
        }
        System.out.println("1부터 100까지 합계 = " + sum2);

        int sum3 = 0;
        for (int i = 100;i <= sum2;i = i + 1) {
            sum3 = sum3 + i;
        }
        System.out.println("100부터 " + sum2 + "까지 합계 = " + sum3);

    }

    public static int getSum(int start, int end) {
        int sum = 0;
        for (int i = start;i <= end;i = i + 1) {
            sum = sum + i;
        }
        return sum;
    }
    
}
