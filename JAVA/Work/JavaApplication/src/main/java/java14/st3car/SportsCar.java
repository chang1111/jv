package java14.st3car;

public class SportsCar extends Car {
    private boolean turbo;
    
    public SportsCar() {
        super();
    }
    public SportsCar(int speed, int gear, String color) {
        super(speed, gear, color);
    }
    public SportsCar(boolean turbo) {
        super();
        this.turbo = turbo;
    }
    public SportsCar(String color, boolean turbo) {
        super(color);
        this.turbo = turbo;
    }
    public SportsCar(int speed, int gear, String color, boolean turbo) {
        super(speed, gear, color);
        this.turbo = turbo;
    }
    public boolean getTurbo() {
        return turbo;
    }
    public void setTurbo(boolean turbo) {
        this.turbo = turbo;
    }
    @Override
    public String toString() {
        return "SportsCar [turbo=" + turbo + ", toString()=" + super.toString()
                + "]";
    }
    
}
