package java06;

import java.util.Scanner;

public class ex06_03_isNumber {
    
    public static boolean isNumber (String x) {
        if (x == null || x == "") {
            return false;
        }
        else {
            return true;
        }
    }
    
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("문자열을 입력하세요 : ");
        String str = keyboard.next();
        keyboard.close();

        boolean result = isNumber(str);
        System.out.println(result);
    }
    
}
