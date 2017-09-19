package java03;

import java.util.Scanner;

public class ex03_02_MaxNumber {
    
    public static void main(String[] args) {

        int x = 0, y = 0, z = 0;
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("첫번째 수를 입력하세요. ");
        x = keyboard.nextInt();
        System.out.print("두번째 수를 입력하세요. ");
        y = keyboard.nextInt();
        System.out.print("세번째 수를 입력하세요. ");
        z = keyboard.nextInt();
        keyboard.close();
        
        if (x > y) {
            if (x > z) {
                System.out.println("입력 받은 수 중 가장 큰 수는 " + x + "입니다.");
            }
            else {
                System.out.println("입력 받은 수 중 가장 큰 수는 " + z + "입니다.");
            }
        }
        else {
            if (y > z) {
                System.out.println("입력 받은 수 중 가장 큰 수는 " + y + "입니다.");
            }
            else {
                System.out.println("입력 받은 수 중 가장 큰 수는 " + z + "입니다.");
            }
        }
        
        if (x > y && x > z) {
            System.out.println("입력 받은 수 중 가장 큰 수는 " + x + "입니다.");
        }
        else if (y > z){
            System.out.println("입력 받은 수 중 가장 큰 수는 " + y + "입니다.");
        }
        else {
            System.out.println("입력 받은 수 중 가장 큰 수는 " + z + "입니다.");
        }
        
        System.out.println("입력 받은 수 중 가장 큰 수는 " + (x > y ? (x > z ? x : z) : (y > z ? y : z)) + "입니다.");
    }
    
}
