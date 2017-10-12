package java11.st4;

import java.util.Scanner;

public class OperTest {
    
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("First num : ");
        int n1 = keyboard.nextInt();
        System.out.print("Second num : ");
        int n2 = keyboard.nextInt();
        
        Oper op = new Oper(n1, n2);
        int add = op.Add();
        int minus = op.Minus();
        int mul = op.Mul();
        double div = op.Div();
        op.printResult("Add", add);
        op.printResult("Minus", minus);
        op.printResult("Mul", mul);
        op.printResult("Double", div);

    }
    
}
