package 도서관리프로그램;

import java.util.Date;

public class 대여목록 {
    private Integer 대여번호;
    private String 이름;
    private String 전화번호;
    private String 주민번호;
    private String 메일주소;
    private String 책제목;
    private String 출판사;
    private String 장르;
    private String 저자;
    private Integer 책번호;
    private String 대여날짜;
    
    public 대여목록() {
        super();
    }

    public 대여목록(Integer 대여번호, String 이름, String 전화번호, String 주민번호, String 메일주소,
            String 책제목, String 출판사, String 장르, String 저자, Integer 책번호,
            String 대여날짜) {
        super();
        this.대여번호 = 대여번호;
        this.이름 = 이름;
        this.전화번호 = 전화번호;
        this.주민번호 = 주민번호;
        this.메일주소 = 메일주소;
        this.책제목 = 책제목;
        this.출판사 = 출판사;
        this.장르 = 장르;
        this.저자 = 저자;
        this.책번호 = 책번호;
        this.대여날짜 = 대여날짜;
    }

    public Integer get대여번호() {
        return 대여번호;
    }

    public void set대여번호(Integer 대여번호) {
        this.대여번호 = 대여번호;
    }

    public String get이름() {
        return 이름;
    }

    public void set이름(String 이름) {
        this.이름 = 이름;
    }

    public String get전화번호() {
        return 전화번호;
    }

    public void set전화번호(String 전화번호) {
        this.전화번호 = 전화번호;
    }

    public String get주민번호() {
        return 주민번호;
    }

    public void set주민번호(String 주민번호) {
        this.주민번호 = 주민번호;
    }

    public String get메일주소() {
        return 메일주소;
    }

    public void set메일주소(String 메일주소) {
        this.메일주소 = 메일주소;
    }

    public String get책제목() {
        return 책제목;
    }

    public void set책제목(String 책제목) {
        this.책제목 = 책제목;
    }

    public String get출판사() {
        return 출판사;
    }

    public void set출판사(String 출판사) {
        this.출판사 = 출판사;
    }

    public String get장르() {
        return 장르;
    }

    public void set장르(String 장르) {
        this.장르 = 장르;
    }

    public String get저자() {
        return 저자;
    }

    public void set저자(String 저자) {
        this.저자 = 저자;
    }

    public Integer get책번호() {
        return 책번호;
    }

    public void set책번호(Integer 책번호) {
        this.책번호 = 책번호;
    }

    public String get대여날짜() {
        return 대여날짜;
    }

    public void set대여날짜(String 대여날짜) {
        this.대여날짜 = 대여날짜;
    }
    
}
