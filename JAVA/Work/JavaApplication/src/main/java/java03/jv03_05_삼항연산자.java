package java03;

public class jv03_05_삼항연산자 {
    
    public static void main(String[] args) {
        
        int x = 10, y = 20;
        int max = 0;
        
        if (x > y)
            max = x;
        else
            max = y;
        
        System.out.println(max);
        
        max = x > y ? x : y;
        System.out.println(max);
        
    }
    
}
