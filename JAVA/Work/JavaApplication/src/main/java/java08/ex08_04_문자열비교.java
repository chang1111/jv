package java08;

import java.util.Scanner;

public class ex08_04_문자열비교 {
    
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("-----------------------------------");
        System.out.print("Please input first  string : ");
        String s1 = keyboard.next();
        System.out.print("Please input second string : ");
        String s2 = keyboard.next();
        String result = new String();
        if (s1.equals(s2)) {
            result = "same";
        }
        else {
            result = "different";
        }
        System.out.println("result : " + result);
        if (s1 == s2) {
            result = "same";
        }
        else {
            result = "different";
        }
        System.out.println("result : " + result);
        
    }
    
}
