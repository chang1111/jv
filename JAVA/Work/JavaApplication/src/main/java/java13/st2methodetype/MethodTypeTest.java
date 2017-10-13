package java13.st2methodetype;

public class MethodTypeTest {
    
    public static void main(String[] args) {
        
        MethodType m = new MethodType();
        
        m.instanceMethod(); // instace.method
        
        MethodType.staticMethod(); // class.method
    }
    
}
