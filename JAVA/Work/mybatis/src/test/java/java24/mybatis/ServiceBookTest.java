package java24.mybatis;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java24.mybatis.model.ModelBook;
import java24.mybatis.svr.ServiceBook;

public class ServiceBookTest {
    
    private static ServiceBook service = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        ApplicationContext context = new
                ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        
        service = context.getBean("servicebook", ServiceBook.class);
    }
    
    @Test
    public void testGetCount() throws Exception {
        ModelBook book = new ModelBook();
        int rs = service.getCount(null);
        assertEquals(4, rs);
    }
    
    @Test
    public void testGetMaxBookid() throws Exception {
        int rs = service.getMaxBookid();
        assertEquals(4, rs);
    }
    
    @Test
    public void testSelectAll() throws Exception {
        ModelBook book = new ModelBook();
        List<ModelBook> rs = service.selectAll(book);
        assertEquals(new Integer(1), rs.get(0).getBookid());
        assertEquals("operating system", rs.get(0).getBookname());
        assertEquals("wiley", rs.get(0).getPublisher());
        assertEquals("2003", rs.get(0).getYear());
        assertEquals(new Integer(2), rs.get(1).getBookid());
        assertEquals("mysql", rs.get(1).getBookname());
        assertEquals("oreilly", rs.get(1).getPublisher());
        assertEquals("2009", rs.get(1).getYear());
        assertEquals(new Integer(3), rs.get(2).getBookid());
        assertEquals("java", rs.get(2).getBookname());
        assertEquals("hall", rs.get(2).getPublisher());
        assertEquals("2013", rs.get(2).getYear());

    }
    
    @Test
    public void testSelectLike() throws Exception {
        ModelBook book = new ModelBook();
        book.setBookname("a");
        List<ModelBook> rs = service.selectLike(book);
        assertEquals(new Integer(1), rs.get(0).getBookid());
        assertEquals("operating system", rs.get(0).getBookname());
        assertEquals("wiley", rs.get(0).getPublisher());
        assertEquals("2003", rs.get(0).getYear());
        assertEquals(new Integer(3), rs.get(1).getBookid());
        assertEquals("java", rs.get(1).getBookname());
        assertEquals("hall", rs.get(1).getPublisher());
        assertEquals("2013", rs.get(1).getYear());
    }
    
    @Test
    public void testSelectEqual() throws Exception {
        ModelBook book = new ModelBook();
        book.setBookname("mysql");
        List<ModelBook> rs = service.selectEqual(book);
        assertEquals(new Integer(2), rs.get(0).getBookid());
        assertEquals("mysql", rs.get(0).getBookname());
        assertEquals("oreilly", rs.get(0).getPublisher());
        assertEquals("2009", rs.get(0).getYear());
    }
    
    @Test
    public void testInsertBook() throws Exception {
        ModelBook book = new ModelBook();
        book.setBookname("photoshop");
        book.setPublisher("abc");
        int rs = service.insertBook(book);
        assertEquals(8, rs);
        assertTrue(rs >= 1);
    }
    
    @Test
    public void testInsertMap() throws Exception {
        String bookname = "photoshop";
        java.util.Date dtm = java.sql.Date.valueOf("2007-02-01");
        Integer authid =10;
        int rs = service.insertMap(bookname, dtm, authid);
        assertEquals(10, rs);
        assertTrue(rs >= 1);
    }
    
    @Test
    public void testUpdateBook() throws Exception {
        ModelBook wherebook = new ModelBook();
        ModelBook setbook = new ModelBook();
        wherebook.setBookname("photoshop");
        setbook.setBookname("javascript");
        setbook.setYear("2000");
        setbook.setPrice(25000);
        int rs = service.updateBook(wherebook, setbook);
        assertTrue(rs >= 0);
    }
    
    @Test
    public void testDeleteBook() throws Exception {
        ModelBook book = new ModelBook();
        book.setBookname("javascript");
        int rs = service.deleteBook(book);
        assertTrue(rs >= 0);
    }
    
    @Test
    public void testSelectDynamic() throws Exception {
        ModelBook book = new ModelBook();
        book.setBookid(2);
        book.setBookname("mysql");
        book.setPublisher("oreilly");
        List<ModelBook> rs = service.selectDynamic(book);
        assertEquals(new Integer(2), rs.get(0).getBookid());
        assertEquals("mysql", rs.get(0).getBookname());
        assertEquals("oreilly", rs.get(0).getPublisher());
    }
    
}
