package java12.st4emp;

public class Employee {
    private String name;
    private int salary;
    private static int count = 0;
    
    public Employee() {
        super();
        count++;
    }
    public Employee(String name, int salary) {
        super();
        count++;
        this.name = name;
        this.salary = salary;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public String getName() {
        return name;
    }
    public int getSalary() {
        return salary;
    }
    
    @Override
    public String toString() {
        return "Employee [name=" + name + ", salary=" + salary + "]";
    }
    
    public static int getCount() {
        return count;
    }

}
