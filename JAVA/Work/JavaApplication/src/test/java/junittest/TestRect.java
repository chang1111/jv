package junittest;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestRect {
    private static Rect r = null;
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        r = new Rect();
    }
    
    @Test
    public void testArea() {
        r.setWidth(2);
        r.setHeight(5);
        int result = r.area();
        assertEquals(10, result);
        assertTrue(result == 10);
        assertFalse(result != 10);
        r.setWidth(7);
        r.setHeight(6);
        result = r.area();
        assertEquals(42, result);
        assertTrue(result == 42);
        assertFalse(result != 42);
    }

    @Test
    public void testPerimeter() {
        r.setWidth(2);
        r.setHeight(5);
        int result = r.perimeter();
        assertEquals(14, result);
        assertTrue(result == 14);
        assertFalse(result != 14);
        r.setWidth(7);
        r.setHeight(6);
        result = r.perimeter();
        assertEquals(26, result);
        assertTrue(result == 26);
        assertFalse(result != 26);
    }
    
}
