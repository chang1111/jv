package java03;

import java.util.Scanner;

public class ex03_01_LargeSmall {
    
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int n = keyboard.nextInt();
        keyboard.close();
        
        if (n >= 100)
            System.out.println("large");
        else
            System.out.println("small");
    }
}
