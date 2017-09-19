package java03;

import java.util.Scanner;

public class ex03_03 {
    
    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in);
        int k = keyboard.nextInt();
        keyboard.close();
        
        if (k == 0) {
            System.out.println('A');
        }
        else if (k > 3) {
            System.out.println('B');
        }
        else {
            System.out.println('C');
        }
        
    }
    
}
