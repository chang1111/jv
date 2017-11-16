package 전화번호관리;

public class PhoneUnivInfo extends PhoneInfo {
    private String major = "";
    private int year = 0;
    
    public PhoneUnivInfo() {
        super();
    }

    public PhoneUnivInfo(String name, String phoneNumber, String major, int year) {
        super(name, phoneNumber);
        this.major = major;
        this.year = year;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    public void showPhoneInfo() {
        System.out.println("전화번호 : " + getPhoneNumber());
        System.out.println("전공 : " + major);
        System.out.println("학년 : " + year);
    }
    
}
