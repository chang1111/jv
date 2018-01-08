package com.spring65.phone;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring65.phone.inf.IServicePhone;
import com.spring65.phone.model.ModelPhone;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestServicePhone {
    
    private static ApplicationContext context = null;
    private static IServicePhone service = null;
        
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        
        context = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml");
        service = context.getBean("servicephone", IServicePhone.class);
    }    
 
    @Test
    public void testGetPhoneOne() {

        String name = "name";
       
        ModelPhone result= service.getPhoneOne(name);
        
        assertEquals("name" , result.getName());
        assertEquals("sk", result.getManufacturer());
        assertEquals(60000, (int)result.getPrice());
    }
  
}
