package java16.st2interface;

public class Television implements RemoteControl, SerialCommunication {

    public void turnOn(){
        System.out.println("Television.turnOn()");
    }

    public void turnOff() {
        System.out.println("Television.turnOff()");
    }

    public void moveLeft() {
        System.out.println("Television.moveLeft()");
    }

    public void moveRight() {
        System.out.println("Television.moveRight()");
    }

    public void send() {
        
    }

    public void receive() {
        
    }
    
}
