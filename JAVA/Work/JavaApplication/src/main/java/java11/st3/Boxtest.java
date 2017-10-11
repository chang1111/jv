package java11.st3;

public class Boxtest {
    
    public static void main(String[] args) {
//        int tmp = 0;
        
        // Box 인스턴스 생성하시오
        Box box = new Box();
        // width : 100
        box.setWidth(100);
        // length : 100
        box.setLength(100);
        // height : 100
        box.setHeight(100);
        
        // 부피를 계산하고 출력하시오
        box.printVolume();
        
//        System.out.println(box.toString());
    }
    
}
