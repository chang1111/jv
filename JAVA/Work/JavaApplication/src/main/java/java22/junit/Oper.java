package java22.junit;

public class Oper {
    private int x;
    private int y;
    
    public Oper() {
        
    }
    
    public Oper(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Oper [x=" + x + ", y=" + y + "]";
    }
    
    public int add() {
        return x + y;
    }

    public int minus() {
        return x - y;
    }

    public int mul() {
        return x * y;
    }

    public double div() {
        return (double)x / y;
    }
    
    public void print() {
        System.out.println("Add : " + add());
        System.out.println("Minus : " + minus());
        System.out.println("Mul : " + mul());
        System.out.println("Div : " + div());
    }

}
