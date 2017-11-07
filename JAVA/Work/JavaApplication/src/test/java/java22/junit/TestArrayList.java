package java22.junit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestArrayList {
    private static List<String> elist = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        elist = new ArrayList<String>();
        elist.add("0");
        elist.add("2");
        elist.add("1");
        elist.add("3");
        elist.add("4");
    }
    
    @Test
    public void test01() {
        assertNotNull(elist);
    }

    @Test
    public void test02() {
        assertEquals(5, elist.size());
    }

    @Test
    public void test03() {
        int result = elist.indexOf("10");
//        assertEquals(-1, result);
        assertFalse(elist.contains("10"));
    }

    @Test
    public void test04() {
        String[] names = {"y2kpooh", "hwang"};
        String[] names2 = {"y2kpooh", "hwang"};
        assertArrayEquals(names2, names);
    }

}
