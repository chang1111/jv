package java14.st5animal;

public class Dog extends Animal {
    public void bark() {
        System.out.println(this + "bark");
    }
    @Override
    public String toString() {
        return "Dog ";
    }
}
