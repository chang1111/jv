package java02;

public class jv02_16_ex {
    
    public static void main(String[] args) {
        
        int x = 1;
        int y = 1;
        int a = ++x * 2; //a의 값은
//      x = x + 1;
//      a = x * 2;
        
        int b = y++ * 2; //b의 값은
//      b = y * 2;
//      y = y + 1;
        
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
    
}
