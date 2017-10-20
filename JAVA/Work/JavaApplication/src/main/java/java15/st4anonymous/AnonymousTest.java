package java15.st4anonymous;

public class AnonymousTest {
    
    public static void main(String[] args) {
        TV tv1 = new TV();
        
        RemoteControl tv2 = new TV();

        RemoteControl tv3 = new RemoteControl() {
            
            public void turnOn() {
                
            }
            
            public void turnOff() {
                
            }
            
            public void moveRight() {
                
            }
            
            public void moveLeft() {
                
            }
        };
        
    }
    
}
