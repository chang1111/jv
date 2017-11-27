package board;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import board.model.ModelUser;
import board.service.ServiceUser;

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
        user.setUserid("kim");
        int rs = service.insertUser(user);
        assertTrue(rs >= 1);
    }
    
    @Test
    public void testLogin() throws Exception {
        ModelUser user = new ModelUser();
        user.setUserid("asdasd");
        user.setPasswd("1111");
        List<ModelUser> rs = service.login(user);
        Integer userno = rs.get(0).getUserno();
        String userid = rs.get(0).getUserid();
        String name = rs.get(0).getName();
        assertEquals(new Integer(1), userno);
        assertEquals("asdasd", userid);
        assertEquals("pppp", name);
    }
    
    @Test
    public void testLogout() throws Exception {
        fail("Not yet implemented");
    }
    
    @Test
    public void testUpdateUserInfo() throws Exception {
        ModelUser searchValue = new ModelUser();
        ModelUser updateValue = new ModelUser();
        searchValue.setUserid("kim");
        updateValue.setName("kim");
        updateValue.setPasswd("1234");
        int rs = service.updateUserInfo(searchValue, updateValue);
        assertTrue(rs >= 0);
    }
    
    @Test
    public void testUpdatePasswd() throws Exception {
        String userid = "kim";
        String currentPasswd = "1234";
        String newPasswd = "1111";
        int rs = service.updatePasswd(userid, currentPasswd, newPasswd);
        assertTrue(rs >= 0);
    }
    
    @Test
    public void testDeleteUser() throws Exception {
        ModelUser user = new ModelUser();
        user.setUserid("kim");
        int rs = service.deleteUser(user);
        assertTrue(rs >= 0);
    }
    
    @Test
    public void testSelectUserOne() throws Exception {
        ModelUser user = new ModelUser();
        user.setUserno(1);
        List<ModelUser> rs = service.selectUserOne(user);
        Integer userno = rs.get(0).getUserno();
        String userid = rs.get(0).getUserid();
        String passwd = rs.get(0).getPasswd();
        assertEquals(new Integer(1), userno);
        assertEquals("asdasd", userid);
        assertEquals("1111", passwd);
    }
    
    @Test
    public void testSelectUserList() throws Exception {
        ModelUser user = new ModelUser();
        List<ModelUser> rs = service.selectUserList(user);
        Integer userno = rs.get(0).getUserno();
        String userid = rs.get(0).getUserid();
        String passwd = rs.get(0).getPasswd();
        assertEquals(new Integer(1), userno);
        assertEquals("asdasd", userid);
        assertEquals("1111", passwd);
        userno = rs.get(1).getUserno();
        userid = rs.get(1).getUserid();
        passwd = rs.get(1).getPasswd();
        assertEquals(new Integer(2), userno);
        assertEquals("kim", userid);
        assertEquals("1111", passwd);
    }
    
    @Test
    public void testCheckuserid() throws Exception {
        String userid = "kim";
        int rs = service.checkuserid(userid);
        assertEquals(1, rs);
    }
    
}
