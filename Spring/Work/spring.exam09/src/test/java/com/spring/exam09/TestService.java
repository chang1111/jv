package com.spring.exam09;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestService {
    private static IServicePhone service = null;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml");
        service = context.getBean(IServicePhone.class);
    }
    
    @Test
    public void test01InsertPhone() {
        ModelPhone phone = new ModelPhone();
        phone.setPhname("test");
        phone.setPhfactory("test");
        phone.setPhprice(20000);
        
        int result = service.insertPhone(phone);
        
        assertTrue(result > 0);
    }
    
    @Test
    public void test02GetPhoneList() {
        List<ModelPhone> result = service.getPhoneList();
        
        // 인스턴스 검증
        assertNotNull(result);
        
        // 값 검증
        assertEquals("test", result.get(0).getPhname());
        assertEquals("test", result.get(0).getPhfactory());
        assertEquals(20000, (int)result.get(0).getPhprice());
        
    }
    
}
