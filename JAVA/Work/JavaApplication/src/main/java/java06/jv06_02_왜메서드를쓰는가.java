package java06;

public class jv06_02_왜메서드를쓰는가 {

    public static int getSum(int start, int end) {
        int sum = 0;
        for (int i = start;i <= end;i = i + 1) {
            sum = sum + i;
        }
        return sum;
    }

    public static void main(String[] args) {
        int sum = 0;
        sum = getSum(1, 10);
        System.out.println("1부터 10까지 합계 = " + sum);

        int sum2 = 0;
        sum2 = getSum(1, 100);
        System.out.println("1부터 100까지 합계 = " + sum2);

        int sum3 = 0;
        sum3 = getSum(100, sum2);
        System.out.println("100부터 " + sum2 + "까지 합계 = " + sum3);

    }
    
}
