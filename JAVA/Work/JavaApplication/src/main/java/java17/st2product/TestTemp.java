package java17.st2product;

import java.util.Scanner;

public class TestTemp {
    private static Scanner keyboard = new Scanner(System.in);
    private static int count = 0;
    public static void main(String[] args) {
        Product[] prod = new Product[10];
        for (;;) {
            System.out.print("상품추가(1), 모든 상품 조회(2), 종료(3)>>>");
            int menu = keyboard.nextInt();
            if (menu == 1) {
                상품입력(prod);
            }
            else if (menu == 2) {
                상품출력(prod);
            }
            else if (menu == 3) {
                break;
            }
            else {
                System.out.println("잘못된 입력");
            }
        }
        
    }


    private static void 상품입력(Product[] prod) {
        System.out.print("상품 종류 책(1), 음악CD(2), 회화책(3)>>>");
        int menu = keyboard.nextInt();
        if (menu == 1) {
            System.out.print("상품 설명>>>");
            String 상품설명 = keyboard.next();
            System.out.print("생산자>>>");
            String 생산자 = keyboard.next();
            System.out.print("가격>>>");
            int 가격 = keyboard.nextInt();
            System.out.print("ISBN번호>>>");
            int ISBN번호 = keyboard.nextInt();
            System.out.print("저자>>>");
            String 저자 = keyboard.next();
            System.out.print("책제목>>>");
            String 책제목 = keyboard.next();
            prod[count++] = new Book(1, 상품설명, 생산자, 가격, ISBN번호, 저자, 책제목);
        }
        else if (menu == 2) {
            System.out.print("상품 설명>>>");
            String 상품설명 = keyboard.next();
            System.out.print("생산자>>>");
            String 생산자 = keyboard.next();
            System.out.print("가격>>>");
            int 가격 = keyboard.nextInt();
            System.out.print("앨범제목>>>");
            String 앨범제목 = keyboard.next();
            System.out.print("가수이름>>>");
            String 가수이름 = keyboard.next();
            prod[count++] = new CompactDisc(2, 상품설명, 생산자, 가격, 앨범제목, 가수이름);
            
        }
        else if (menu == 3) {
            System.out.print("상품 설명>>>");
            String 상품설명 = keyboard.next();
            System.out.print("생산자>>>");
            String 생산자 = keyboard.next();
            System.out.print("가격>>>");
            int 가격 = keyboard.nextInt();
            System.out.print("ISBN번호>>>");
            int ISBN번호 = keyboard.nextInt();
            System.out.print("저자>>>");
            String 저자 = keyboard.next();
            System.out.print("책제목>>>");
            String 책제목 = keyboard.next();
            System.out.print("언어명>>>");
            String 언어명 = keyboard.next();
            prod[count++] = new ConversationBook(3, 상품설명, 생산자, 가격, ISBN번호, 저자, 책제목, 언어명);
        }
    }

    private static void 상품출력(Product[] prod) {
        for (Product i : prod) {
            if (i != null)
            System.out.println(i);
        }
        
    }

}
