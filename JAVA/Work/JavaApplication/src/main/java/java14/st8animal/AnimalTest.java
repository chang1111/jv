package java14.st8animal;

public class AnimalTest {
    
    public static void main(String[] args) {
        Animal a = new Animal();
        a.sleep();
        a.eat();
        
        Dog d = new Dog();
        d.sleep();
        d.eat();
        d.bark();
        
        Cat c = new Cat();
        c.sleep();
        c.eat();
        c.play();
        
    }
    
}
