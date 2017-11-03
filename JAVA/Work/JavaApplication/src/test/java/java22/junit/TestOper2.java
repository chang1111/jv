package java22.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestOper2 {
    
    @Test
    public void test_add() {
        Oper op = new Oper(5, 5);
        int r = op.add();
        assertEquals(10, r);
    }
    
    @Test
    public void test_minus() {
        Oper op = new Oper(5, 5);
        int r = op.minus();
        assertEquals(0, r);
    }
    
    @Test
    public void test_mul() {
        Oper op = new Oper(5, 5);
        int r = op.mul();
        assertEquals(25, r);
    }
    
    @Test
    public void test_div() {
        Oper op = new Oper(5, 5);
        double r = op.div();
        assertEquals(1, r, 0.0);
    }
    
}
