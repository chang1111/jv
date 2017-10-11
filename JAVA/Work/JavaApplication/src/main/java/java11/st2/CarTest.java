package java11.st2;

public class CarTest {
    
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.speedUp(100);
        myCar.speedPrint();
        System.out.println(myCar.toString());
        
//        Car yourCar = new Car("파랑", 60, 3);
//        System.out.println(yourCar.toString());
        
        Car yourCar = new Car();
        yourCar.setColor("파랑");
        yourCar.setSpeed(60);
        yourCar.setGear(3);
        System.out.println(yourCar.toString());
    }
    
}
