package java02;

public class jv02_21_형변환 {
    
    public static void main(String[] args) {
        
        int i = 43;
        
        double d = (double)i;
        System.out.println(d);
        
        char c = (char)i;
        System.out.println(c);
        
        boolean b = (i != 0);
        System.out.println(b);
        
        String s = Integer.toString(i);
        System.out.println(s);
        
    }
    
}
