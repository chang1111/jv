package java06;

import java.util.Scanner;

public class ex06_03_isNumber {
    
    public static boolean isNumber (String x) {
        int count = 0;
        for (int i = 0;i < x.length();i = i + 1){
            if (x.charAt(i) >= '0' && x.charAt(i) <= '9') {
                count = count + 1;
            }
        }
        if (count == x.length()) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("문자열을 입력하세요 : ");
        String x = keyboard.next();
        keyboard.close();

        boolean result = isNumber(x);
        System.out.println(result);
    }
    
}
