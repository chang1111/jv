package java14.st3car;

public class SportsCarTest {
    
    public static void main(String[] args) {
        
        SportsCar c1 = new SportsCar();
        
        c1.setColor("white");
        c1.setGear(6);
        c1.setSpeed(250);
        c1.setTurbo(true);
        
        SportsCar c2 = new SportsCar(300, 5, "green", true);
        
        SportsCar c3 = new SportsCar(true);
        
        SportsCar c4 = new SportsCar("black", true);
        
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        
    }
    
}
