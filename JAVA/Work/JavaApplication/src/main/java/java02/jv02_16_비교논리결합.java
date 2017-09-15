package java02;

public class jv02_16_비교논리결합 {
    
    public static void main(String[] args) {
        
        int x = 3;
        int y = 4;
        
        System.out.println((x == y) && (x != y));
        System.out.println((x > y) || (x < y));
        System.out.println((x >= y) || (x <= y));
        System.out.println((x == y) && (x != y) || (x < y));
    }
    
}
