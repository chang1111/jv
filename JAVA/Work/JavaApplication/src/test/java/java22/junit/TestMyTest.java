package java22.junit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestMyTest {
    public static MyUnit myUnit = null;
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        myUnit = new MyUnit();
    }
    
    @Test
    public void testConcate() {
        String s = myUnit.concate("a", "b");
        assertEquals("ab", s);
    }
    
    @Test
    public void testGetBoolean() {
        boolean b = myUnit.getBoolean();
        assertFalse(b);
    }
    
    @Test
    public void testGetSameObject() {
        Object o = myUnit.getSameObject();
        assertEquals(null, o);
    }
    
    @Test
    public void testGetObject() {
        Object o = myUnit.getObject();
        assertNull(o);
    }
    
    @Test
    public void testGetStringArray() {
        String[] s = myUnit.getStringArray();
        assertArrayEquals(new String[]{"one", "two", "three"}, s);
    }
    
    @Test(expected = ArithmeticException.class)
    public void testGetException() {
        double e = myUnit.getException();
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testExceptionMessage() {
        ArrayList<String> list = myUnit.getEmptyList();
        String s = list.get(0);
    }
}
