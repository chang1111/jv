package java22.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
    
public class TestOper {
    @Test
    public void testAdd() {
        // Oper 클래스의 인스턴스 생성
        Oper op = new Oper(2,4);
        
        int rs = op.add();
        assertEquals(6, rs);
    }
    @Test
    public void testMinus() {
        // Oper 클래스의 인스턴스 생성
        Oper op = new Oper(2,4);
        
        int rs = op.minus();
        assertEquals(-2, rs);
    }
    @Test
    public void testMul() {
        // Oper 클래스의 인스턴스 생성
        Oper op = new Oper(2,4);
        
        int rs = op.mul();
        assertEquals(8, rs);
    }
    @Test
    public void testDiv() {
        // Oper 클래스의 인스턴스 생성
        Oper op = new Oper(2,4);
        
        double rs = op.div();
        assertEquals(0.5, rs, 0.0);
    }

    
}
