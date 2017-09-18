package java03;

import java.util.Scanner;

public class jv03_03_중첩ifelse {
    
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int grade = keyboard.nextInt();
        keyboard.close();
        System.out.println("Grade : " + grade);
        
        if (grade >= 90)
            System.out.println("학점 : A");
        else if (grade >= 80)
            System.out.println("학점 : B");
        else if (grade >= 70)
            System.out.println("학점 : C");
        else if (grade >= 60)
            System.out.println("학점 : D");
        else
            System.out.println("학점 : F");
    }
}
