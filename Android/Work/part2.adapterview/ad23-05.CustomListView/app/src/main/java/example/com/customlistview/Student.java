package example.com.customlistview;

import android.support.annotation.NonNull;

/**
 * Created by Administrator on 2017-12-29.
 */

public class Student implements Comparable {
    private String name;
    private String number;
    private String department;

    public Student() {

    }

    public Student(String name, String number, String department) {
        this.name = name;
        this.number = number;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int compareTo(Object student) {
        return name.compareTo(((Student)student).getName());
    }
}
