package test;

public class PhoneInfo {
    private String name = "";
    private String phoneNumber = "";
    
    public PhoneInfo() {
        super();
    }

    public PhoneInfo(String name, String phoneNumber) {
        super();
        this.name = name;
        this.phoneNumber = phoneNumber;
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
    
    public void showPhoneInfo() {
        System.out.println("전화번호 : " + phoneNumber);
    }
    
}
