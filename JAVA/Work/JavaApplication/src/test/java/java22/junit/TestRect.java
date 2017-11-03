package java22.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestRect {
    private static Rect r = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("setUpBeforeClass");
        
        r = new Rect();
        r.setWidth(2);
        r.setHeight(30);
    }
    
    @Before
    public void setUp() throws Exception {
        System.out.println("setUp");
    }
    
    @Test
    public void test_area() {
        int a= r.area();
        assertEquals(60, a);
    }

    @Test
    public void test_perimeter() {
        int p = r.perimeter();
        assertEquals(64, p);
    }

    @Test
    public void test_null() {
        Rect o = r.type();
        assertNull(o);
    }
}
