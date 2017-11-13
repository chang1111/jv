package java23.jdbc;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestDaoAuth {
    private static Connection conn = null;
    private static DaoAuth dao = null;
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        conn = DBConnect.makeConnection();
        dao = new DaoAuth(conn);
    }
    
    @Test
    public void testGetCount() throws SQLException {
        ModelAuth auth = new ModelAuth();
        int result = dao.getCount(auth);
        assertEquals(3, result);
    }
    
    @Test
    public void testGetMaxAuthid() throws SQLException {
        ModelAuth auth = new ModelAuth();
        int result = dao.getMaxAuthid();
        assertEquals(7, result);
    }
    
    @Test
    public void testSelectAll() throws SQLException {
        ModelAuth auth = new ModelAuth();
        ResultSet rs = dao.selectAll();
        rs.next();
        int authid = rs.getInt("authid");
        String name = rs.getString("name");
        assertEquals(1, authid);
        assertEquals("bob", name);
        rs.next();
        authid = rs.getInt("authid");
        name = rs.getString("name");
        assertEquals(2, authid);
        assertEquals("kim", name);
    }
    
    @Test
    public void testSelectLike() throws SQLException {
        ModelAuth auth = new ModelAuth();
        auth.setName("ki");
        ResultSet rs = dao.selectLike(auth);
        rs.next();
        String name = rs.getString("name");
        assertEquals("kim", name);
        
    }
    
    @Test
    public void testSelectEqual() throws SQLException {
        ModelAuth auth = new ModelAuth();
        auth.setName("bob");
        ResultSet rs = dao.selectEqual(auth);
        rs.next();
        String name = rs.getString("name");
        assertEquals("bob", name);
    }
    
    @Test
    public void testSelectDynamic() throws SQLException {
        ModelAuth auth = new ModelAuth();
//        auth.setAuthid(1);
        auth.setName("bob");
        ResultSet rs = dao.selectDynamic(auth);
        rs.next();
        String name = rs.getString("name");
        assertEquals("bob", name);
    }
    
    @Test
    public void testInsertAuth() throws SQLException {
        ModelAuth auth = new ModelAuth();
        auth.setAuthid(8);
        auth.setName("asdasd");
        auth.setBirth("2000.02.02");
        int rs = dao.insertAuth(auth);
        assertTrue(rs >= 1);
    }
    
    @Test
    public void testUpdateAuth() throws SQLException {
        ModelAuth whereauth = new ModelAuth();
        whereauth.setName("asdasd");
        ModelAuth setauth = new ModelAuth();
        setauth.setName("ah");
        setauth.setBirth("2017.11.13");
        int rs = dao.updateAuth(whereauth, setauth);
        assertTrue(rs >= 0);
    }
    
    @Test
    public void testDeleteAuth() throws SQLException {
        ModelAuth auth = new ModelAuth();
        auth.setName("ah");
        int rs = dao.deleteAuth(auth);
        assertTrue(rs >= 0);
    }
    
}
