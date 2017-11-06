package java22.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestOper2 {
    
    @Test
    public void test_add() {
        Oper op = new Oper(2, 4);
        int r = op.add();
        assertEquals(6, r);
        assertNotEquals(5, r);
        assertTrue(r == 6);
        assertFalse(r != 6);
        assertNotNull(r);
    }
    
    @Test
    public void test_minus() {
        Oper op = new Oper(2, 4);
        int r = op.minus();
        assertEquals(-2, r);
    }
    
    @Test
    public void test_mul() {
        Oper op = new Oper(2, 4);
        int r = op.mul();
        assertEquals(8, r);
    }
    
    @Test
    public void test_div() {
        Oper op = new Oper(2, 4);
        double r = op.div();
        assertEquals(0.5, r, 0.0);
    }
    
}
