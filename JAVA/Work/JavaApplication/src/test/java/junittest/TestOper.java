package junittest;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestOper {
    private static Oper op = null;
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        op = new Oper();
    }
    
    @Test
    public void testAdd() {
        op.setX(3);
        op.setY(5);
        int result = op.add();
        assertEquals(8, result);
        assertTrue(result == 8);
        assertFalse(result != 8);
        op.setX(5);
        op.setY(1);
        result = op.add();
        assertEquals(6, result);
        assertTrue(result == 6);
        assertFalse(result != 6);
    }
    
    @Test
    public void testMinus() {
        op.setX(3);
        op.setY(5);
        int result = op.minus();
        assertEquals(-2, result);
        assertTrue(result == -2);
        assertFalse(result != -2);
        op.setX(5);
        op.setY(1);
        result = op.minus();
        assertEquals(4, result);
        assertTrue(result == 4);
        assertFalse(result != 4);
    }
    
    @Test
    public void testMul() {
        op.setX(3);
        op.setY(5);
        int result = op.mul();
        assertEquals(15, result);
        assertTrue(result == 15);
        assertFalse(result != 15);
        op.setX(5);
        op.setY(1);
        result = op.mul();
        assertEquals(5, result);
        assertTrue(result == 5);
        assertFalse(result != 5);
    }
    
    @Test
    public void testDiv() {
        op.setX(3);
        op.setY(5);
        double result = op.div();
        assertEquals(0.6, result, 0.0);
        assertTrue(result == 0.6);
        assertFalse(result != 0.6);
        op.setX(5);
        op.setY(1);
        result = op.div();
        assertEquals(5, result, 0.0);
        assertTrue(result == 5.0);
        assertFalse(result != 5.0);
    }
    
}
