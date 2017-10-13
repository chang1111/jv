package java13.st4emp;

import java.util.Scanner;

public class EmployeeTest {
    
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        Employee[] employees = new Employee[3];
        
        for (int i = 0;i < employees.length;i++) {
            System.out.println("직원" + (i + 1) + "의 정보");
            System.out.print("이름 : ");
            String name = keyboard.next();
            System.out.print("주소 : ");
            String address = keyboard.next();
            System.out.print("주민번호 : ");
            String rrn = keyboard.next();
            System.out.print("월급 : ");
            int salary = keyboard.nextInt();
            System.out.println();
            employees[i] = new Employee();
            employees[i].setName(name);
            employees[i].setAddress(address);
            employees[i].setRrn(rrn);
            employees[i].setSalary(salary);
        }
        
//        for (int i = 0;i < employees.length;i++) {
//            String name = employees[i].getName();
//            String address = employees[i].getAddress();
//            String rrn = employees[i].getRrn();
//            int salary = employees[i].getSalary();
//            System.out.println((i + 1) + ". name : " + name + ", address : " + address + ", rrn : " + rrn + ", salary : " + salary);
//        }
        
        for (int i = 0;i < employees.length;i++) {
            System.out.println((i + 1) + ". " + employees[i].toString());
        }
    }
    
}
