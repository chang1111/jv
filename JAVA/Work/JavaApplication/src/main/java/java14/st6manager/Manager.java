package java14.st6manager;

public class Manager extends Employee {
    private int bonus;
    
    public Manager() {
        super();
    }

    public Manager(String name, String address, int salary, String rrn,
            int bonus) {
        super(name, address, salary, rrn);
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "Manager [bonus=" + bonus + ", toString()=" + super.toString()
                + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + bonus;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Manager other = (Manager) obj;
        if (bonus != other.bonus)
            return false;
        return true;
    }

    public void test() {
//        String info = "name : " + getName();
//        info += "\naddress : " + getAddress();
//        info += "\nsalary : " + salary;
//        info += "\nrrn : " + getRrn();
//        
//        System.out.println(info);
        
        System.out.println("name : " + getName());
        System.out.println("address : " + getAddress());
        System.out.printf("salary : %,d\n", salary);
        System.out.println("rrn : " + getRrn());
    }
}
