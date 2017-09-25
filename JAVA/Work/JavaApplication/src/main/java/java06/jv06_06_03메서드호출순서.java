package java06;

public class jv06_06_03메서드호출순서 {
    
    public static void main(String[] args) {
        int a = 3, b = 4;
        int value = Add(a, b);
        
        System.out.println(value);
        
    }
    
    public static int Add(int x, int y) {
        int result = x + y;
        return result;
    }
}
