package test;

public class PhoneInfo {
    private String name = "";
    private String phoneNumber = "";
    private String birthday = "";
    
    public PhoneInfo() {
        super();
    }

    public PhoneInfo(String name, String phoneNumber, String birthday) {
        super();
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    
    public void showPhoneInfo() {
        System.out.println("전화번호 : " + phoneNumber);
        System.out.println("생년월일 : " + birthday);
    }
    
}
