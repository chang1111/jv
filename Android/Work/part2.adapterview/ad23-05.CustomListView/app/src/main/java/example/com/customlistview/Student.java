package example.com.customlistview;

import org.apache.commons.collections.Predicate;

import java.util.Comparator;

/**
 * Created by Administrator on 2017-12-29.
 */

public class Student {
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

    public static class NameCompare implements Comparator<Student> {

        private int mode = 1;

        public NameCompare(boolean desc) {
            if (desc) {
                mode = -1;
            }
        }
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getName().compareTo(o2.getName()) * mode;
        }
    }
    public static class NumberCompare implements Comparator<Student> {

        private int mode = 1;

        public NumberCompare(boolean desc) {
            if (desc) {
                mode = -1;
            }
        }
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getNumber().compareTo(o2.getNumber()) * mode;
        }
    }
    public static class DepartmentCompare implements Comparator<Student> {

        private int mode = 1;

        public DepartmentCompare(boolean desc) {
            if (desc) {
                mode = -1;
            }
        }
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getDepartment().compareTo(o2.getDepartment()) * mode;
        }
    }

    public static class MyPredicate implements Predicate {

        private String fieldName;
        private Object value;

        public MyPredicate(String fieldName, Object value) {
            this.fieldName = fieldName;
            this.value = value;
        }

        @Override
        public boolean evaluate(Object object) {
            if (fieldName.equals("name")) {
                return ((Student)object).getName().contains(value.toString());
            }
            else if (fieldName.equals("number")) {
                return ((Student)object).getNumber().contains(value.toString());
            }
            else if (fieldName.equals("department")) {
                return ((Student)object).getDepartment().contains(value.toString());
            }
            else {
                return false;
            }
        }
    }
}
