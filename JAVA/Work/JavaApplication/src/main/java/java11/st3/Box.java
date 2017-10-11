package java11.st3;

public class Box {
    private int width;
    private int length;
    private int height;
    
    // getter & setter
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    
    // constructor
    public Box() {
        super();
    }
    
    // toString()
    @Override
    public String toString() {
        return "Box [width=" + width + ", length=" + length + ", height="
                + height + "]";
    }
    
    // getVolume() 메서드
    // 가로 * 세로 * 높이
    public int getVolume() {
        return width * length * height;
    }
    
    // printVolume() 메서드
    // getVolume()으로 얻은 결과 출력
    public void printVolume() {
        int volume = getVolume();
        System.out.println(volume);
    }
}
