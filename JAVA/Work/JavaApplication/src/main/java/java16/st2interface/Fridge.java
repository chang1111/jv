package java16.st2interface;

public class Fridge implements RemoteControl  {
    
    public void turnOn() {
        System.out.println("Fridge.turnOn()");
    }
    
    public void turnOff() {
        System.out.println("Fridge.turnOff()");
    }

    public void moveLeft() {
        System.out.println("Fridge.moveLeft()");
    }

    public void moveRight() {
        System.out.println("Fridge.moveRight()");
    }
    
}
