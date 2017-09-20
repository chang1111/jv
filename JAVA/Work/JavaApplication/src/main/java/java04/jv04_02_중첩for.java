package java04;

public class jv04_02_중첩for {
    
    public static void main(String[] args) {
        System.out.println("**********");
        System.out.println("**********");
        System.out.println("**********");
        System.out.println("**********");
        System.out.println("**********");
        System.out.println("----------");
        for (int i = 0;i < 5;i++) {
            System.out.println("**********");
        }
        System.out.println("----------");
        for (int i = 0;i < 5;i++) {
            for (int j = 0;j < 10;j++) {
                System.out.print('*');
            }
            System.out.println();
        }
        
    }
    
}
