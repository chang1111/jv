package java23.jdbc;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.annotations.Results;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestServiceAuth {
    private static ServiceAuth svr = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        svr = new ServiceAuth();
    }
    
    @Test
    public void testGetCount() throws SQLException {
        ModelAuth auth = new ModelAuth();
        int result = svr.getCount(auth);
        assertEquals(3, result);
    }
    
    @Test
    public void testGetMaxAuthid() throws SQLException {
        int result = svr.getMaxAuthid();
        assertEquals(7, result);
    }
    
    @Test
    public void testSelectAll() throws SQLException {
        ResultSet rs = svr.selectAll();
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
        rs.next();
        authid = rs.getInt("authid");
        name = rs.getString("name");
        assertEquals(7, authid);
        assertEquals("park", name);
    }
    
    @Test
    public void testSelectLike() throws SQLException {
        ModelAuth auth = new ModelAuth();
        auth.setName("b");
        ResultSet rs = svr.selectLike(auth);
        rs.next();
        int authid = rs.getInt("authid");
        String name = rs.getString("name");
        String birth = rs.getString("birth");
        assertEquals(1, authid);
        assertEquals("bob", name);
        assertEquals("1970.05.01", birth);
        
    }
    
    @Test
    public void testSelectEqual() throws SQLException {
        ModelAuth auth = new ModelAuth();
        auth.setName("kim");
        ResultSet rs = svr.selectEqual(auth);
        rs.next();
        int authid = rs.getInt("authid");
        String name = rs.getString("name");
        String birth = rs.getString("birth");
        assertEquals(2, authid);
        assertEquals("kim", name);
        assertEquals("1980.05.01", birth);
    }
    
    @Test
    public void testSelectDynamic() throws SQLException {
        ModelAuth auth = new ModelAuth();
        auth.setAuthid(7);
        auth.setName("park");
        auth.setBirth("2000.05.01");
        ResultSet rs = svr.selectDynamic(auth);
        rs.next();
        int authid = rs.getInt("authid");
        String name = rs.getString("name");
        String birth = rs.getString("birth");
        assertEquals(7, authid);
        assertEquals("park", name);
        assertEquals("2000.05.01", birth);
    }
    
    @Test
    public void testInsertAuth() throws SQLException {
        ModelAuth auth = new ModelAuth();
        auth.setAuthid(8);
        auth.setName("joo");
        auth.setBirth("2017.11.13");
        int rs = svr.insertAuth(auth);
        assertTrue(rs >= 1);
    }
    
    @Test
    public void testUpdateAuth() throws SQLException {
        ModelAuth whereauth = new ModelAuth();
        ModelAuth setauth = new ModelAuth();
        whereauth.setName("joo");
        setauth.setName("jo");
        setauth.setBirth("2017.11.11");
        int rs = svr.updateAuth(whereauth, setauth);
        assertTrue(rs >= 0);
    }
    
    @Test
    public void testDeleteAuth() throws SQLException {
        ModelAuth auth = new ModelAuth();
        auth.setName("jo");
        int rs = svr.deleteAuth(auth);
        assertTrue(rs >= 0);
    }
    
}
