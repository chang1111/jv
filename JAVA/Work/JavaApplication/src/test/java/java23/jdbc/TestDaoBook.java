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
    public void testSelectLike() throws SQLException {
        ModelBook book = new ModelBook();
        book.setBookname("sql");
        ResultSet rs = dao.selectLike(book);
        rs.next();
        int bookid = rs.getInt("bookid");
        assertEquals(2, bookid);
        String bookname = rs.getString("bookname");
        assertEquals("mysql", bookname);
        rs.next();
        bookid = rs.getInt("bookid");
        assertEquals(4, bookid);
        bookname = rs.getString("bookname");
        assertEquals("first sql", bookname);

    }
    
    @Test
    public void testSelectEqual() throws SQLException {
        ModelBook book = new ModelBook();
        book.setBookname("mysql");
        ResultSet rs = dao.selectEqual(book);
        assertNotNull(rs);
        rs.next();
        int bookid = rs.getInt("bookid");
        assertEquals(2, bookid);
        String bookname = rs.getString("bookname");
        assertEquals("mysql", bookname);
    }
    
    @Test
    public void testSelectDynamic() throws SQLException {
        ModelBook book = new ModelBook();
        book.setBookid(1);
        book.setBookname("");
        ResultSet rs = dao.selectDynamic(book);
        assertNotNull(rs);
        rs.next();
        int bookid = rs.getInt("bookid");
        String bookname = rs.getString("bookname");
        assertEquals(1, bookid);
        assertEquals("operating system", bookname);
        
        book.setBookid(3);
        book.setBookname("java");
        rs = dao.selectDynamic(book);
        rs.first();
        bookid = rs.getInt("bookid");
        bookname = rs.getString("bookname");
        assertEquals(3, bookid);
        assertEquals("java", bookname);
        
        book.setBookid(2);
        book.setBookname("mysql");
        rs = dao.selectDynamic(book);
        rs.last();
        bookid = rs.getInt("bookid");
        bookname = rs.getString("bookname");
        assertEquals(2, bookid);
        assertEquals("mysql", bookname);
    }
    
    @Test
    public void testInsertBook() throws SQLException {
        
        java.sql.Date date = java.sql.Date.valueOf("2017-11-08");
        ModelBook book = new ModelBook();
        book.setBookname("test");
        book.setPublisher("abc");
        book.setYear("2017");
        book.setPrice(20000);
        book.setDtm(date);
        book.setUse_yn(true);
        book.setAuthid(5);
        int rs = dao.insertBook(book);
        assertTrue(rs >= 1);
    }
    
    @Test
    public void testUpdateBook() throws SQLException {
        ModelBook wherebook = new ModelBook();
        ModelBook setbook = new ModelBook();
        wherebook.setBookname("test");
        setbook.setYear("2020");
        setbook.setPrice(50000);
        int rs = dao.updateBook(wherebook, setbook);
        assertTrue(rs >= 0);
    }
    
    @Test
    public void testDeleteBook() throws SQLException {
        ModelBook book = new ModelBook();
        book.setBookname("test");
        int rs = dao.deleteBook(book);
        assertTrue(rs >= 0);
    }
    
}
