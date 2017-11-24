package board;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import board.model.ModelUser;
import model.service.ServiceUser;

public class TestServiceUser {
    
    private static ServiceUser service = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        ApplicationContext context = new
                ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        
        service = context.getBean("serviceuser", ServiceUser.class);
    }
    
    @Test
    public void testInsertUser() throws Exception {
        ModelUser user = new ModelUser();
        user.setUserid("asdasd");
        int rs = service.insertUser(user);
        assertTrue(rs >= 1);
    }
    
    @Test
    public void testLogin() throws Exception {
        fail("Not yet implemented");
    }
    
    @Test
    public void testLogout() throws Exception {
        fail("Not yet implemented");
    }
    
    @Test
    public void testUpdateUserInfo() throws Exception {
        fail("Not yet implemented");
    }
    
    @Test
    public void testUpdatePasswd() throws Exception {
        fail("Not yet implemented");
    }
    
    @Test
    public void testDeleteUser() throws Exception {
        fail("Not yet implemented");
    }
    
    @Test
    public void testSelectUserOne() throws Exception {
        fail("Not yet implemented");
    }
    
    @Test
    public void testSelectUserList() throws Exception {
        fail("Not yet implemented");
    }
    
    @Test
    public void testCheckuserid() throws Exception {
        fail("Not yet implemented");
    }
    
}
