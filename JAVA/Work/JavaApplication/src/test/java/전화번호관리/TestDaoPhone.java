package 전화번호관리;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestDaoPhone {
    private static Connection conn = null;
    private static DaoPhone dao = null;
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        conn = DBConnect.makeConnection();
        dao = new DaoPhone(conn);
    }
    
    @Test
    public void testGetCount() throws SQLException {
        fail("Not yet implemented");
    }
    
    @Test
    public void testSelectAll() throws SQLException {
        fail("Not yet implemented");
    }
    
    @Test
    public void testSelectLike() throws SQLException {
        fail("Not yet implemented");
    }
    
    @Test
    public void testSelectEqual() throws SQLException {
        fail("Not yet implemented");
    }
    
    @Test
    public void testSelectDynamic() throws SQLException {
        fail("Not yet implemented");
    }
    
    @Test
    public void testInsertPhone() throws SQLException {
        ModelPhone phone = new ModelPhone();
        phone.setName("a");
        phone.setPhoneNumber("010-0000-0000");
        int rs = dao.insertPhone(phone);
        assertTrue(rs >= 1);
    }
    
    @Test
    public void testUpdatePhone() throws SQLException {
        fail("Not yet implemented");
    }
    
    @Test
    public void testDeletePhone() throws SQLException {
        fail("Not yet implemented");
    }
    
}
