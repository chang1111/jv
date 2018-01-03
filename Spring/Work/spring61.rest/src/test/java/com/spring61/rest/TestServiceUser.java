package com.spring61.rest;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring61.rest.inf.IServiceUser;
import com.spring61.rest.model.ModelUser;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestServiceUser {
    
    private static IServiceUser service = null;

    Date from = new Date();
    String userid = "MISS A" + new SimpleDateFormat("yyMMddhhmm").format(from);

    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml");
        service = context.getBean("serviceuser", IServiceUser.class);  

        
        // DB Table 초기화 코드
        javax.sql.DataSource dataSource = context.getBean("dataSource", javax.sql.DataSource.class);                 
        org.apache.ibatis.jdbc.ScriptRunner runner = new org.apache.ibatis.jdbc.ScriptRunner(dataSource.getConnection());
        runner.setAutoCommit(true);
        runner.setStopOnError(true);
        String sqlScriptFilePath = ClassLoader.getSystemClassLoader().getResource("java21/ddl/board.ddl.mysql.sql").getFile();
        java.io.Reader br = new java.io.BufferedReader(new java.io.FileReader(sqlScriptFilePath ));
        runner.runScript( br);
        runner.closeConnection();
    }

    @Test
    public void test01_SelectUserOne() {
        ModelUser user = new ModelUser();
        user.setUserno(1);

        ModelUser result = service.selectUserOne(user);
        
        assertEquals(result.getUserid(), "userid");
    }

    @Test
    public void test02_SelectUserList() {
        
        ModelUser user = new ModelUser();
        
        user.setUserid("userid");
        List<ModelUser> result = service.selectUserList(user); 
        assertNotNull( result );
        assertTrue( result.size() >= 1 );
    }

    @Test
    public void test03_Login() {
        String userid = "userid";
        String passwd = "password";

        ModelUser result = service.login(userid, passwd);        
        assertNotNull(result);
        assertEquals(userid, result.getUserid() );
        assertSame(1     , result.getUserno() );
    }

    @Test
    public void test04_Logout() {
    }

    @Test
    public void test05_checkuserid() {
        String userid= "userid" ;
        int result = service.checkuserid(userid);
        
        assertSame(1, result );
    }

    @Test
    public void test21_InsertUser() {
        ModelUser user = new ModelUser();
        user.setUserid( this.userid );
        user.setEmail("missa@naver.com");
        user.setMobile("010-3214-6879");
        user.setInsertDT(from);
        user.setInsertUID("ufy uygyu");
        user.setName("miss");
        user.setPasswd("miss1234");
        user.setUpdateDT(from);
        user.setUpdateUID("uytf yui");
        
        int result = service.insertUser(user);
        
        assertEquals(result, 1);
    }
    
    @Test
    public void test31_updateUserInfo() {
        ModelUser updatevalue = new ModelUser();
        updatevalue.setEmail("sonyo@hanmail.net");
        updatevalue.setMobile("010-5555-6666");
        updatevalue.setName("98g uhu ihuu");
        updatevalue.setRetireYN(true);
        updatevalue.setPasswd("girls8888");
        updatevalue.setUpdateDT(from);
        updatevalue.setUpdateUID("JYP");
        
        ModelUser searchvalue = new ModelUser();
        searchvalue.setUserid( this.userid ); 
        
        int result = service.updateUserInfo(updatevalue, searchvalue);   
        
        assertEquals(1, result);
    }

    @Test
    public void test32_updatePasswd() {
        ModelUser user = new ModelUser();
        user.setUserid( this.userid ); 
        user.setPasswd("uuji");
        
        String userid        = "userid";
        String currentPasswd = "password";
        String newPasswd     = "newpass";
        
        int result = service.updatePasswd(userid, currentPasswd, newPasswd);
        
        assertEquals(result, 1);
    }

    @Test
    public void test33_UpdateRetire() {
        ModelUser searchvalue = new ModelUser();
        searchvalue.setUserid(this.userid); 
        
        int result = service.updateRetire(searchvalue);
        
        assertEquals(result, 1);
    }
    
}
