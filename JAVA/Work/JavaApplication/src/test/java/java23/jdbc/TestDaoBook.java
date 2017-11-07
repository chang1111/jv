package java23.jdbc;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestDaoBook {
    private static Connection conn = null;
    private static DaoBook dao = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        conn = DBConnect.makeConnection();
        dao = new DaoBook(conn);
    }
    
    @Test
    public void testGetCount() throws SQLException {
        ModelBook book = new ModelBook();
        int result = dao.getCount(book);
        assertEquals(4, result);
    }
    
    @Test
    public void testGetMaxBookid() throws SQLException {
        int result = dao.getMaxBookid();
        assertEquals(4, result);
    }
    
    @Test
    public void testSelectAll() throws SQLException {
        ResultSet rs = dao.selectAll();
        rs.next();
        int bookid = rs.getInt("bookid");
        assertEquals(1, bookid);
        String bookname = rs.getString("bookname");
        assertEquals("operating system", bookname);
    }
    
    @Test
    public void testSelectLike() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testSelectEqual() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testSelectDynamic() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testInsertBook() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testUpdateBook() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testDeleteBook() {
        fail("Not yet implemented");
    }
    
}
