package java14.st5animal;

public class Cat extends Animal {
    public void play() {
        System.out.println(this + "play");
    }
    @Override
    public String toString() {
        return "Cat ";
    }
}
