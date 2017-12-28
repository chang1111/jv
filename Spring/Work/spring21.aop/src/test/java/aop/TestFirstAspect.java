package aop;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.ModelProduct;
import service.IServiceProduct;

public class TestFirstAspect {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private ApplicationContext context;
    private static IServiceProduct service;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] {"classpath:aop.xml"} );
        service = context.getBean("svrprod", IServiceProduct.class);
    }
    
    @Test
    public void testGetProduct() {
        ModelProduct product =  service.getProduct("bbb");
        assertTrue(1000 == product.getPrice());
    }
}
