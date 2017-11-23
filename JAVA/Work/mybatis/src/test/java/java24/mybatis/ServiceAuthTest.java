package java24.mybatis;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java24.mybatis.model.ModelAuth;
import java24.mybatis.svr.ServiceAuth;

public class ServiceAuthTest {
    
    private static ServiceAuth service = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        ApplicationContext context = new
                ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        
        service = context.getBean("serviceauth", ServiceAuth.class);
    }
    
    @Test
    public void testGetCount() throws Exception {
        ModelAuth auth = new ModelAuth();
        int rs = service.getCount(auth);
        assertEquals(3, rs);
    }
    
    @Test
    public void testGetMaxAuthid() throws Exception {
        int rs = service.getMaxAuthid();
        assertEquals(7, rs);
    }
    
    @Test
    public void testSelectAll() throws Exception {
        ModelAuth auth = new ModelAuth();
        List<ModelAuth> rs = service.selectAll(auth);
        assertEquals(new Integer(1), rs.get(0).getAuthid());
        assertEquals("bob", rs.get(0).getName());
        assertEquals("1970.05.01", rs.get(0).getBirth());
        assertEquals(new Integer(2), rs.get(1).getAuthid());
        assertEquals("kim", rs.get(1).getName());
        assertEquals("1980.05.01", rs.get(1).getBirth());
        assertEquals(new Integer(7), rs.get(2).getAuthid());
        assertEquals("park", rs.get(2).getName());
        assertEquals("2000.05.01", rs.get(2).getBirth());
        assertEquals(3, rs.size());
    }
    
    @Test
    public void testSelectLike() throws Exception {
        ModelAuth auth = new ModelAuth();
        auth.setName("k");
        List<ModelAuth> rs = service.selectLike(auth);
        assertEquals(new Integer(2), rs.get(0).getAuthid());
        assertEquals("kim", rs.get(0).getName());
        assertEquals("1980.05.01", rs.get(0).getBirth());
        assertEquals(new Integer(7), rs.get(1).getAuthid());
        assertEquals("park", rs.get(1).getName());
        assertEquals("2000.05.01", rs.get(1).getBirth());
        assertEquals(2, rs.size());
    }
    
    @Test
    public void testSelectEqual() throws Exception {
        ModelAuth auth = new ModelAuth();
        auth.setName("bob");
        List<ModelAuth> rs = service.selectLike(auth);
        assertEquals(new Integer(1), rs.get(0).getAuthid());
        assertEquals("bob", rs.get(0).getName());
        assertEquals("1970.05.01", rs.get(0).getBirth());
        assertEquals(1, rs.size());
    }
    
    @Test
    public void testInsertAuth() throws Exception {
        ModelAuth auth = new ModelAuth();
        auth.setAuthid(10);
        auth.setName("lee");
        auth.setBirth("2010.05.01");
        int rs = service.insertAuth(auth);
        assertTrue(rs >= 1);
    }
    
    @Test
    public void testUpdateAuth() throws Exception {
        ModelAuth whereauth = new ModelAuth();
        ModelAuth setauth = new ModelAuth();
        whereauth.setName("lee");
        setauth.setBirth("2020.05.01");
        int rs = service.updateAuth(whereauth, setauth);
        assertTrue(rs >= 0);
    }
    
    @Test
    public void testDeleteAuth() throws Exception {
        ModelAuth auth = new ModelAuth();
        auth.setName("lee");
        int rs = service.deleteAuth(auth);
        assertTrue(rs >= 0);
    }
}
