package 전화번호관리;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

public class TestPhoneInfo {
    private static Connection conn = DBConnect.makeConnection();
    private static DaoPhone dao = new DaoPhone(conn);
    public static void main(String[] args) throws SQLException {
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
                System.out.println("1. 일반, 2. 대학, 3. 회사");
                System.out.print("선택>> ");
                int n1 = keyboard.nextInt();
                System.out.print("이름 : ");
                String name = keyboard.next();
                if (map.containsKey(name)) {
                    System.out.println("중복된 이름입니다.");
                }
                else {
                    System.out.print("전화번호 : ");
                    String phoneNumber = keyboard.next();
                    if (n1 == 1) {
                        ModelPhone phone = new ModelPhone();

//                        map.put(name, new PhoneInfo(name, phoneNumber));
                        phone.setName(name);
                        phone.setPhoneNumber(phoneNumber);
                        dao.insertPhone(phone);
                    }
                    else if (n1 == 2) {
                        ModelPhoneUniv phone = new ModelPhoneUniv();
                        System.out.print("전공 : ");
                        String major = keyboard.next();
                        System.out.print("학년 : ");
                        int year = keyboard.nextInt();
//                        map.put(name, new PhoneUnivInfo(name, phoneNumber, major, year));
                        phone.setName(name);
                        phone.setPhoneNumber(phoneNumber);
                        phone.setMajor(major);
                        phone.setYear(year);
                        dao.insertPhone(phone);
                    }
                    else if (n1 == 3) {
                        ModelPhoneCompany phone = new ModelPhoneCompany();
                        System.out.print("회사 : ");
                        String company = keyboard.next();
//                        map.put(name, new PhoneCompanyInfo(name, phoneNumber, company));
                        phone.setName(name);
                        phone.setPhoneNumber(phoneNumber);
                        phone.setCompany(company);
                        dao.insertPhone(phone);
                    }
                    else {
                        System.out.println(n + "에 해당하는 선택은 존재하지 않습니다.");
                        System.out.println("메뉴 선택을 처음부터 다시 진행합니다.");
                        continue;
                    }
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
            else {
                System.out.println(n + "에 해당하는 선택은 존재하지 않습니다.");
                System.out.println("메뉴 선택을 처음부터 다시 진행합니다.");
            }
        }
    }
    
}
