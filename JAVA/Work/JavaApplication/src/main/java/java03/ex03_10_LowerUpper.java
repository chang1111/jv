package java03;

import java.util.Scanner;

public class ex03_10_LowerUpper {
    
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("ch : ");
        char ch = keyboard.next().charAt(0);

        if (ch >= 'A' && ch <= 'Z') {
            ch = (char)(ch + 32);
            System.out.print("ch to lowerCase : ");
        }
        else if (ch >= 'a' && ch <= 'z') {
            ch = (char)(ch - 32);
            System.out.print("ch to upperCase : ");
        }
        System.out.println(ch);
        
    }
    
}
