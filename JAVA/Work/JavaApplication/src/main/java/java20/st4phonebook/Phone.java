package java20.st4phonebook;

public class Phone {
    private String name;
    private String address;
    private String phone;
    
    public Phone() {
        super();
    }

    public Phone(String name, String address, String phone) {
        super();
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return name + " " + address + " "
                + phone;
    }
    
}
