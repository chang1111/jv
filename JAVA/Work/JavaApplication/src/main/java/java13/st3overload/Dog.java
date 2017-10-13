package java13.st3overload;

public class Dog {
    public void sound() {
        System.out.println("sound");
    }
    public void sleep() {
        System.out.println("sleep()");
    }
    public void sleep(int x) {
        System.out.println("sleep(int x)");
    }
    public void sleep(String x) {
        System.out.println("sleep(String x)");
    }
    public void sleep(String x, int y) {
        System.out.println("sleep(String x, int y)");
    }
    public void sleep(int x, String y) {
        System.out.println("sleep(int x, String y)");
    }
    
}
