package java11.st4;

public class Oper {
    private int n1;
    private int n2;
    
    public Oper(int n1, int n2) {
        super();
        this.n1 = n1;
        this.n2 = n2;
    }
    
    public int Add() {
        return n1 + n2;
    }
    public int Minus() {
        return n1 - n2;
    }
    public int Mul() {
        return n1 * n2;
    }
    public double Div() {
        return (double)n1 / n2;
    }
    public void printResult(String oper, int result) {
        System.out.println(oper + " : " + result);
    }
    public void printResult(String oper, double result) {
        System.out.printf("%s : %.6f\n", oper, result);
    }

}
