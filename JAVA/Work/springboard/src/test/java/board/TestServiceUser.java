package board;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import board.model.ModelUser;
import board.service.ServiceUser;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestServiceUser {
    
    private static ServiceUser service = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        ApplicationContext context = new
                ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        
        service = context.getBean("serviceuser", ServiceUser.class);
        // DB Table 초기화 코드
      javax.sql.DataSource dataSource = (javax.sql.DataSource)context.getBean("dataSource");
      
      org.apache.ibatis.jdbc.ScriptRunner runner = new
      org.apache.ibatis.jdbc.ScriptRunner( dataSource.getConnection() );
      runner.setAutoCommit(true);
      runner.setStopOnError(true);
      ClassLoader cl = ClassLoader.getSystemClassLoader();
      String sf = cl.getResource("ddl/board.ddl.mysql.sql").getFile();
      java.io.Reader br = new java.io.BufferedReader( new java.io.FileReader(sf) );
      runner.runScript( br);
      runner.closeConnection();
    }
    
    @Test
    public void test00InsertUser() throws Exception {
        ModelUser user = new ModelUser();
        user.setUserid("asdasd");
        user.setPasswd("1111");
        user.setName("yong");
        int rs = service.insertUser(user);
        user.setUserid("qweqwe");
        user.setPasswd("1234");
        user.setName("yong");
        rs = service.insertUser(user);
        assertTrue(rs >= 1);
    }
    
    @Test
    public void test01Login() throws Exception {
        ModelUser user = new ModelUser();
        user.setUserid("asdasd");
        user.setPasswd("1111");
        List<ModelUser> rs = service.login(user);
        Integer userno = rs.get(0).getUserno();
        String userid = rs.get(0).getUserid();
        String name = rs.get(0).getName();
        assertEquals(new Integer(1), userno);
        assertEquals("asdasd", userid);
        assertEquals("yong", name);
    }
    
//    @Test
//    public void test02Logout() throws Exception {
//        fail("Not yet implemented");
//    }
    
    @Test
    public void test03UpdateUserInfo() throws Exception {
        ModelUser searchValue = new ModelUser();
        ModelUser updateValue = new ModelUser();
        searchValue.setUserid("asdasd");
        updateValue.setName("qqqq");
        updateValue.setPasswd("1234");
        int rs = service.updateUserInfo(searchValue, updateValue);
        assertTrue(rs >= 0);
    }
    
    @Test
    public void test04UpdatePasswd() throws Exception {
        String userid = "asdasd";
        String currentPasswd = "1234";
        String newPasswd = "1111";
        int rs = service.updatePasswd(userid, currentPasswd, newPasswd);
        assertTrue(rs >= 0);
    }
    
    @Test
    public void test05DeleteUser() throws Exception {
        ModelUser user = new ModelUser();
        user.setUserid("asdasd");
        int rs = service.deleteUser(user);
        assertTrue(rs >= 0);
    }
    
    @Test
    public void test06SelectUserOne() throws Exception {
        ModelUser user = new ModelUser();
        user.setUserno(2);
        List<ModelUser> rs = service.selectUserOne(user);
        Integer userno = rs.get(0).getUserno();
        String userid = rs.get(0).getUserid();
        String passwd = rs.get(0).getPasswd();
        assertEquals(new Integer(2), userno);
        assertEquals("qweqwe", userid);
        assertEquals("1234", passwd);
    }
    
    @Test
    public void test07SelectUserList() throws Exception {
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
        assertEquals("qweqwe", userid);
        assertEquals("1234", passwd);
    }
    
    @Test
    public void test08Checkuserid() throws Exception {
        String userid = "qweqwe";
        int rs = service.checkuserid(userid);
        assertEquals(1, rs);
    }
    
}
