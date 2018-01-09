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

        String name = "name0";
       
        ModelPhone result= service.getPhoneOne(name);
        
        assertEquals("name0" , result.getName());
        assertEquals("manufacturer0", result.getManufacturer());
        assertEquals(1000, (int)result.getPrice());
    }
  
    @Test
    public void testGetPhoneList() {

        List<ModelPhone> result= service.getPhoneList();
        
        String name = result.get(0).getName();
        String manufacturer = result.get(0).getManufacturer();
        int price = result.get(0).getPrice();
        assertEquals("name0" , name);
        assertEquals("manufacturer0", manufacturer);
        assertEquals(1000, price);
        
        name = result.get(1).getName();
        manufacturer = result.get(1).getManufacturer();
        price = result.get(1).getPrice();
        assertEquals("name1" , name);
        assertEquals("manufacturer1", manufacturer);
        assertEquals(1100, price);

        name = result.get(2).getName();
        manufacturer = result.get(2).getManufacturer();
        price = result.get(2).getPrice();
        assertEquals("name2" , name);
        assertEquals("manufacturer2", manufacturer);
        assertEquals(1200, price);

    }
  
    @Test
    public void testInsertPhone() {
        
        ModelPhone phone = new ModelPhone("name3", "manufacturer3", 1300);

        int result= service.insertPhone(phone);
        
        assertEquals(result, 1);
        
    }
  
    @Test
    public void testinsertPhoneList() {
        
        List<ModelPhone> phones = new ArrayList<ModelPhone>();
        
        phones.add(new ModelPhone("name4", "manufacturer4", 1400));
        phones.add(new ModelPhone("name5", "manufacturer5", 1500));
        phones.add(new ModelPhone("name6", "manufacturer6", 1600));

        int result= service.insertPhoneList(phones);
        
        assertEquals(result, 3);
        
    }
  
}
