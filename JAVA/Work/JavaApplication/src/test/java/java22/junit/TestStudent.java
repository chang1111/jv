package java22.junit;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestStudent {
    private static Student student = new Student();
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }
    
    @Test
    public void testGrade() {
        student.setScore(100);
        student.setScore(90);
        student.setScore(89);
        student.setScore(80);
        student.setScore(79);
        student.setScore(70);
        student.setScore(69);
        student.setScore(60);
        student.setScore(59);
        String grade = student.getGrade();
        assertEquals("F", grade);
    }
    
}
