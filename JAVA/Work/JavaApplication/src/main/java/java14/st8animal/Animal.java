package java14.st8animal;

public class Animal {
    public void sleep() {
        System.out.println(this + "sleep");
    }
    public void eat() {
        System.out.println(this + "eat");
    }
    @Override
    public String toString() {
        return "Animal ";
    }
}
