package junittest;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestStudent {
    private static Student st = null;
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        st = new Student();
    }
    
    @Test
    public void testGrade() {
        String result = st.getgrade(100);
        assertEquals("A", result);
        assertTrue(result.equals("A"));
        result = st.getgrade(90);
        assertEquals("A", result);
        assertTrue(result.equals("A"));
        result = st.getgrade(89);
        assertEquals("B", result);
        assertTrue(result.equals("B"));
        result = st.getgrade(80);
        assertEquals("B", result);
        assertTrue(result.equals("B"));
        result = st.getgrade(79);
        assertEquals("C", result);
        assertTrue(result.equals("C"));
        result = st.getgrade(70);
        assertEquals("C", result);
        assertTrue(result.equals("C"));
        result = st.getgrade(69);
        assertEquals("D", result);
        assertTrue(result.equals("D"));
        result = st.getgrade(60);
        assertEquals("D", result);
        assertTrue(result.equals("D"));
        result = st.getgrade(59);
        assertEquals("F", result);
        assertTrue(result.equals("F"));
    }
    
}
