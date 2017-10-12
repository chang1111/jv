package java12.st3car;

public class CarTest {
    
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.speedUp(100);
        myCar.speedPrint();
        System.out.println(myCar.toString());
        System.out.println("numberOfCars = " + myCar.getNumberOfcars());
        
        Car yourCar = new Car();
        yourCar.setColor("파랑");
        yourCar.setSpeed(60);
        yourCar.setGear(3);
        System.out.println(yourCar.toString());
        System.out.println("numberOfCars = " + yourCar.getNumberOfcars());
        
        Car otherCar = new Car("파랑", 60, 3);
        System.out.println(otherCar.toString());
        System.out.println("numberOfCars = " + otherCar.getNumberOfcars());
        
        System.out.println("---------------------");
        System.out.println("numberOfCars = " + myCar.getNumberOfcars());
        System.out.println("numberOfCars = " + yourCar.getNumberOfcars());
        System.out.println("numberOfCars = " + otherCar.getNumberOfcars());
        
        System.out.println("---------------------");
        System.out.println(Car.getNumberOfcars());
        System.out.println(Car.numberOfcars);
        
    }
    
}
