package java14.st5animal;

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
