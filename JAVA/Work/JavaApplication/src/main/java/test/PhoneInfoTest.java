package test;

import java.util.*;

public class PhoneInfoTest {
    
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Map<String, PhoneInfo> map = new HashMap<String, PhoneInfo>();
        for (;;) {
            System.out.println("선택하세요...");
            System.out.println("1. 데이터 입력");
            System.out.println("2. 데이터 검색");
            System.out.println("3. 데이터 삭제");
            System.out.println("4. 프로그램 종료");
            System.out.print("선택 : ");
            int n = keyboard.nextInt();
            if (n == 1) {
                System.out.println("데이터 입력을 시작합니다.");
                System.out.print("이름 : ");
                String name = keyboard.next();
                if (map.containsKey(name)) {
                    System.out.println("중복된 이름입니다.");
                }
                else {
                    System.out.print("전화번호 : ");
                    String phoneNumber = keyboard.next();
                    System.out.print("생년월일 : ");
                    String birthday = keyboard.next();
                    map.put(name, new PhoneInfo(name, phoneNumber, birthday));
                    System.out.println("데이터 입력이 완료되었습니다.");
                }
                System.out.println();
            }
            else if (n == 2) {
                System.out.println("데이터 검색을 시작합니다.");
                System.out.print("이름 : ");
                String name = keyboard.next();
                if (map.containsKey(name)) {
                    map.get(name).showPhoneInfo();
                    System.out.println("데이터 검색이 완료되었습니다.");
                }
                else {
                    System.out.println("입력되지 않은 데이터입니다.");
                }
                System.out.println();
            }
            else if (n == 3) {
                System.out.print("이름 : ");
                String name = keyboard.next();
                if (map.containsKey(name)) {
                    map.remove(name);
                    System.out.println("데이터 삭제가 완료되었습니다.");
                }
                else {
                    System.out.println("입력되지 않은 데이터입니다.");
                }
                System.out.println();
            }
            else if (n == 4) {
                System.out.println("종료합니다.");
                break;
            }
        }
    }
    
}
