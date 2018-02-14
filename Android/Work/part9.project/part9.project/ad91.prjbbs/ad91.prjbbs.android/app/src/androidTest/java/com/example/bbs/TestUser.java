package com.example.bbs;

import android.support.test.runner.AndroidJUnit4;

import com.example.bbs.http.HttpUser;
import com.example.bbs.model.*;

import org.apache.commons.lang3.NotImplementedException;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@FixMethodOrder(org.junit.runners.MethodSorters.NAME_ASCENDING)
public class TestUser {

    private static HttpUser http = null;
    private static ModelUser testuser = null;

    @BeforeClass
    public static void Setup() {
        http = new HttpUser();

        testuser = new ModelUser();
        testuser.setName("androidtest1name");
        testuser.setUserid("androidtest1id");
        testuser.setPasswd("androidtest1pw");
        testuser.setEmail("androidtest1email");
    }

    @Test
    public void test01_login() throws Exception {
        ModelUser result = http.login("userid","password");

        assertNotNull(result);
        assertEquals("userid" , result.getUserid() );
    }

    @Test
    public void test02_logout() throws Exception {
        int result = http.logout("userid");

        assertNotNull(result);
        assertEquals(0 , result );
    }

    @Test
    public void test03_checkuserid() throws Exception {
        int result = http.checkuserid("userid");

        assertNotNull(result);
        assertEquals(1 , result );
    }

    @Test
    public void test04_checkpassword() throws Exception {
        int result = http.checkpassword("userid", "password" );

        assertNotNull(result);
        assertEquals(1 , result );
    }


    @Test
    public void test04_SelectUserOne() throws Exception {
        ModelUser user = new ModelUser();
        user.setUserno(1);

        ModelUser result = http.selectUserOne(user);

        assertNotNull(result);
        assertEquals("userid" , result.getUserid() );
    }

    @Test
    public void test05_selectUserList() throws Exception {

        ModelUser user = new ModelUser();
        user.setName("u");

        List<ModelUser> result = http.selectUserList(user);

        assertNotNull(result);
        assertTrue(result.size()>0 );
    }

    @Test
    public void test05_insertUser() throws Exception {

        if( http.checkuserid( testuser.getUserid() ) == 0 ) {
            int result = http.insertUser(testuser);
            assertNotNull(result);
            assertTrue(result > 0 );
        }
    }

    @Test
    public void test06_updatepasswd() throws Exception {

        if( http.checkpassword( testuser.getUserid(), testuser.getPasswd() ) == 1 ) {

            int result = http.updatePasswd(testuser.getUserid(), testuser.getPasswd(), "newpw" );
            assertNotNull(result);
            assertTrue(result > 0 );
        }
    }

    @Test
    public void test07_updateuserinfo() throws Exception {

        ModelUser whereuser = new ModelUser();
        whereuser.setUserid( testuser.getUserid() );

        ModelUser setuser = new ModelUser();
        setuser.setEmail("test_update_email");
        setuser.setPasswd("test_udate_name");
        setuser.setName("test_update_name");

        if( http.checkuserid( testuser.getUserid() ) == 1 ) {

            int result = http.updateUserInfo(setuser, whereuser);
            assertNotNull(result);
            assertTrue(result > 0 );
        }
    }

    @Test
    public void test08_updateretire() throws Exception {

        ModelUser user = new ModelUser();
        user.setUserid( testuser.getUserid() );

        if( http.checkuserid( testuser.getUserid() ) == 1 ) {

            int result = http.updateRetire(user);
            assertNotNull(result);
            assertTrue(result > 0 );
        }
    }
}
