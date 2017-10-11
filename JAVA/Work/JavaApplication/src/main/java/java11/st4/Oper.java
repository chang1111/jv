package java11.st4;

public class Oper {
    private int n1;
    private int n2;
    
    public Oper(int n1, int n2) {
        super();
        this.n1 = n1;
        this.n2 = n2;
    }
    
    public void Add() {
        System.out.println("Add : " + (n1 + n2));
        
    }
    public void Minus() {
        System.out.println("Minus : " + (n1 - n2));
    }
    public void Mul() {
        System.out.println("Mul : " + (n1 * n2));
    }
    public void Div() {
        System.out.printf("Div : %.6f\n ", (double)n1 / n2);
    }
}
