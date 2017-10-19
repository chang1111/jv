package java15.st1inner;

public class OuterClass {
    private String secret = "Time is money";
    
    public OuterClass() {
        InnerClass obj= new InnerClass();
        obj.print();
    }
    
    private class InnerClass {
        public InnerClass() {
            System.out.println("내부 클래스 생성자입니다.");
        }
        
        public void print() {
            System.out.println(secret);
        }
    }
    
}
