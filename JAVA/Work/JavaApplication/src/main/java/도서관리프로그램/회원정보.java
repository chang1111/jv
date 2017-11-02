package 도서관리프로그램;

public class 회원정보 {
    private Integer 회원번호;
    private String 이름;
    private String 주민번호;
    private String 전화번호;
    private String 메일주소;
    
    public 회원정보() {
        super();
    }

    public 회원정보(Integer 회원번호, String 이름, String 주민번호, String 전화번호,
            String 메일주소) {
        super();
        this.회원번호 = 회원번호;
        this.이름 = 이름;
        this.주민번호 = 주민번호;
        this.전화번호 = 전화번호;
        this.메일주소 = 메일주소;
    }

    public Integer get회원번호() {
        return 회원번호;
    }

    public void set회원번호(Integer 회원번호) {
        this.회원번호 = 회원번호;
    }

    public String get이름() {
        return 이름;
    }

    public void set이름(String 이름) {
        this.이름 = 이름;
    }

    public String get주민번호() {
        return 주민번호;
    }

    public void set주민번호(String 주민번호) {
        this.주민번호 = 주민번호;
    }

    public String get전화번호() {
        return 전화번호;
    }

    public void set전화번호(String 전화번호) {
        this.전화번호 = 전화번호;
    }

    public String get메일주소() {
        return 메일주소;
    }

    public void set메일주소(String 메일주소) {
        this.메일주소 = 메일주소;
    }
    
    
}
