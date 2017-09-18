package java02;

public class jv02_24_형변환 {
    
    public static void main(String[] args) {
        
        int result = 0;
        
        result = 1 + '2';
        System.out.println(result);
        
        result = '2' + (true ? 1 : 0);
        System.out.println(result);
        
        result = Integer.valueOf("15") - 5;
        System.out.println(result);
        
        result = Integer.valueOf("1") + '2';
        System.out.println(result);
        
        result = (false ? 1 : 0) + (true ? 1 : 0);
        System.out.println(result);
    }
    
}
