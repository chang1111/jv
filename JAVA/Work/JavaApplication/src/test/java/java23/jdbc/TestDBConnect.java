package java23.jdbc;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestDBConnect {
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }
    
    @Test
    public void test_connectionMySQL() throws Exception {
        Connection conn = DBConnect.makeConnection();
        if (conn != null) {
            assertTrue("db connect", true);
        }
        else {
            assertTrue("db connect", false);
        }
    }
    
    @Test
    public void test_makeConnection() throws Exception {
        Connection conn = DBConnect.makeConnection();
        if (conn != null) {
            assertTrue("db connect", true);
        }
        else {
            assertTrue("db connect", false);
        }
    }
}
