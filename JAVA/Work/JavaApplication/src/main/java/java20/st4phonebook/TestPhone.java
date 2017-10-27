package java20.st4phonebook;

import java.util.*;

public class TestPhone {
    
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Map<String, Phone> map = new HashMap<String, Phone>();
        for (;;) {
            System.out.print("삽입:0, 삭제:1, 찾기:2, 전체보기:3, 종료:4>>");
            int n = keyboard.nextInt();
            if (n == 0) {
                System.out.print("이름>>");
                String name = keyboard.next();
                if (map.containsKey(name)) {
                    System.out.println("중복된 이름입니다.");
                }
                else {
                    System.out.print("주소>>");
                    String address = keyboard.next();
                    System.out.print("전화번호>>");
                    String phone = keyboard.next();
                    map.put(name, new Phone(name, address, phone));
                }
            }
            else if (n == 1) {
                System.out.print("이름>>");
                String name = keyboard.next();
                if (map.containsKey(name)) {
                    map.remove(name);
                    System.out.println(name + "은(는) 삭제되었습니다.");
                }
                else {
                    System.out.println(name + "은(는) 등록되지 않은 사람입니다.");
                }
            }
            else if (n == 2) {
                System.out.print("이름>>");
                String name = keyboard.next();
                if (map.containsKey(name)) {
                    System.out.println(map.get(name));
                }
                else {
                    System.out.println(name + "은(는) 등록되지 않은 사람입니다.");
                }
            }
            else if (n == 3) {
                for (Map.Entry<String, Phone> elem : map.entrySet()) {
                    System.out.println(elem.getValue());
                }
            }
            else if (n == 4) {
                System.out.println("프로그램을 종료합니다...");
                break;
            }
        }
        
    }
    
}
