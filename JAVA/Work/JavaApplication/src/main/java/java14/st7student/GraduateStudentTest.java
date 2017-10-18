package java14.st7student;

public class GraduateStudentTest {
    
    public static void main(String[] args) {
        GraduateStudent s1 = new GraduateStudent();
        
        s1.setNumber(20140000);
        s1.setName("aaaa");
        s1.setPhone("010-****-****");
        s1.setLab("A Lab");
        
        System.out.println(s1);
        
        GraduateStudent s2 = new GraduateStudent();
        
        s2.setNumber(20150000);
        s2.name = "bbbb";
        s2.phone = "010-####-####";
        s2.lab = "B Lab";
        
        System.out.println(s2);
        
        GraduateStudent s3 = new GraduateStudent(20160000, "cccc", "010-@@@@-@@@@", "C Lab");
        
        System.out.println(s3);
    }
    
}
