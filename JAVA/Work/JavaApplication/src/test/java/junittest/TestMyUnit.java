package junittest;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestMyUnit {
    private static MyUnit myUnit = null;
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        myUnit = new MyUnit();
    }
    
    @Test
    public void testConcate() {
        String string = "abcd";
        String string2 = "efgh";
        String result = myUnit.concate(string, string2);
        assertEquals("abcdefgh", result);
    }
    
    @Test
    public void testGetBoolean() {
        boolean b = myUnit.getBoolean();
        assertEquals(false, b);
        assertTrue(!b);
        assertFalse(b);
    }
    
    @Test
    public void testGetSameObject() {
        Object o1 = myUnit.getObject();
        Object o2 = null;
        assertEquals(o1, o2);
        assertSame(o1, o2);
    }
    
    @Test
    public void testGetObject() {
        Object o = myUnit.getObject();
        assertNull(o);
    }
    
    @Test
    public void testGetStringArray() {
        String[] string = myUnit.getStringArray();
        String[] string2 = {"one", "two", "three"};
        assertArrayEquals(string2, string);
    }
    
    @Test(expected = ArithmeticException.class)
    public void testGetException() {
        myUnit.getException();
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetEmptyList() {
        java.util.ArrayList<String> list = myUnit.getEmptyList();
        String s = list.get(0);
    }
    
}
