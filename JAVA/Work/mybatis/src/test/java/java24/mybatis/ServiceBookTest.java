package java24.mybatis;

import static org.junit.Assert.*;

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
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        
        service = context.getBean("servicebook", ServiceBook.class);
    }
    
    @Test
    public void testGetCount() throws Exception {
        fail("Not yet implemented");
    }
    
    @Test
    public void testGetMaxBookid() throws Exception {
        fail("Not yet implemented");
    }
    
    @Test
    public void testSelectAll() throws Exception {
        fail("Not yet implemented");
    }
    
    @Test
    public void testSelectLike() throws Exception {
        fail("Not yet implemented");
    }
    
    @Test
    public void testSelectEqual() throws Exception {
        fail("Not yet implemented");
    }
    
    @Test
    public void testInsertBook() throws Exception {
        fail("Not yet implemented");
    }
    
    @Test
    public void testInsertMap() throws Exception {
        fail("Not yet implemented");
    }
    
    @Test
    public void testUpdateBook() throws Exception {
        fail("Not yet implemented");
    }
    
    @Test
    public void testDeleteBook() throws Exception {
        fail("Not yet implemented");
    }
    
    @Test
    public void testSelectDynamic() throws Exception {
        fail("Not yet implemented");
    }
    
}
