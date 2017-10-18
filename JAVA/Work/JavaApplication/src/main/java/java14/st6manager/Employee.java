package java14.st6manager;

public class Employee {
    private String name;
    private String address;
    protected int salary;
    private String rrn;
    
    public Employee() {
        super();
    }

    public Employee(String name, String address, int salary, String rrn) {
        super();
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.rrn = rrn;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getRrn() {
        return rrn;
    }

    public void setRrn(String rrn) {
        this.rrn = rrn;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", address=" + address + ", salary="
                + salary + ", rrn=" + rrn + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((rrn == null) ? 0 : rrn.hashCode());
        result = prime * result + salary;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (rrn == null) {
            if (other.rrn != null)
                return false;
        } else if (!rrn.equals(other.rrn))
            return false;
        if (salary != other.salary)
            return false;
        return true;
    }
    
}
