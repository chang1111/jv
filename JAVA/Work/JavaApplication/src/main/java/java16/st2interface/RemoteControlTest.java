package java16.st2interface;

public class RemoteControlTest {
    
    public static void main(String[] args) {
        RemoteControl obj = new Television();
        obj.turnOn();
        obj.turnOff();

        obj = new Fridge();
        obj.turnOn();
        obj.turnOff();
        
    }
    
}
