package java23.jdbc;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestServiceBook {
    private static ServiceBook svr = null;
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        svr = new ServiceBook();
    }
    
    @Test
    public void testGetCount() throws SQLException {
        ModelBook book = new ModelBook();
        int rs = svr.getCount(book);
        assertEquals(4, rs);
        
    }
    
    @Test
    public void testGetMaxBookid() throws SQLException {
        int rs = svr.getMaxBookid();
        assertEquals(4, rs);
    }
    
    @Test
    public void testSelectAll() throws SQLException {
        ResultSet rs = svr.selectAll();
        rs.next();
        int bookid = rs.getInt("bookid");
        assertEquals(1, bookid);
        String bookname = rs.getString("bookname");
        assertEquals("operating system", bookname);
        rs.next();
        bookid = rs.getInt("bookid");
        assertEquals(2, bookid);
        bookname = rs.getString("bookname");
        assertEquals("mysql", bookname);
    }
    
    @Test
    public void testSelectLike() throws SQLException {
        ModelBook book = new ModelBook();
        book.setBookname("ja");
        ResultSet rs = svr.selectLike(book);
        rs.next();
        assertTrue(rs.getString("bookname").contains("ja"));
    }
    
    @Test
    public void testSelectEqual() throws SQLException {
        ModelBook book = new ModelBook();
        book.setBookname("mysql");
        ResultSet rs = svr.selectEqual(book);
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
        book.setBookname("operating system");
        ResultSet rs = svr.selectDynamic(book);
        rs.next();
        int bookid = rs.getInt("bookid");
        assertEquals(1, bookid);
        String bookname = rs.getString("bookname");
        assertEquals("operating system", bookname);
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
        int rs = svr.insertBook(book);
        assertTrue(rs >= 1);
    }
    
    @Test
    public void testUpdateBook() throws SQLException {
        ModelBook wherebook = new ModelBook();
        ModelBook setbook = new ModelBook();
        wherebook.setBookname("test");
        setbook.setYear("2020");
        setbook.setPrice(50000);
        int rs = svr.updateBook(wherebook, setbook);
        assertTrue(rs >= 0);
    }
    
    @Test
    public void testDeleteBook() throws SQLException {
        ModelBook book = new ModelBook();
        book.setBookname("test");
        int rs = svr.deleteBook(book);
        assertTrue(rs >= 0);
    }
    
    @Test
    public void testTransCommit() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testTransRollback() {
        fail("Not yet implemented");
    }
    
}
