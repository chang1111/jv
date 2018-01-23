package com.spring.exam08;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPhone {
    private static IServicePhone service = null;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml");
        service = context.getBean(IServicePhone.class);
    }
    
    @Test
    public void test01GetPhoneList() {
        List<ModelPhone> result = service.getPhoneList(1, 10);
        
        // 인스턴스 검증
        assertNotNull(result);
        
        // 값 검증
        assertEquals("name", result.get(0).getName());
        assertEquals("manufacturer", result.get(0).getManufacturer());
        assertEquals(10000, (int)result.get(0).getPrice());
        
    }
    
    @Test
    public void test02GetPhoneOne() {
        fail("Not yet implemented");
    }
    
    @Test
    public void test03InsertPhone() {
        ModelPhone phone = new ModelPhone();
        phone.setName("test");
        phone.setManufacturer("test");
        phone.setPrice(20000);
        
        int result = service.insertPhone(phone);
        
        assertTrue(result > 0);
    }
    
    @Test
    public void test04InsertPhoneList() {
        fail("Not yet implemented");
    }
}
