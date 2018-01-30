package com.spring.pj;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.pj.inf.IServiceUser;
import com.spring.pj.model.ModelUser;

public class TestUser {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static IServiceUser service;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml");
        service = context.getBean(IServiceUser.class);
    }
    
    @Test
    public void testServiceUser() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testInsertUser() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testLogin() {
        String userid = "test";
        String passwd= "1234";
        ModelUser user = service.login(userid, passwd);
        
        assertNotNull(user);
    }
    
    @Test
    public void testLogout() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testUpdateUserInfo() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testUpdatePasswd() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testUpdateRetire() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testSelectUserOne() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testSelectUserList() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testCheckuserid() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testCheckpassword() {
        fail("Not yet implemented");
    }
}
