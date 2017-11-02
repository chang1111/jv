package java22.junit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4jTest {
    private static Logger logger = LoggerFactory.getLogger(Log4jTest.class);
    
    public static void main(String[] args) {
        
//        java.io.File log4jfile = new java.io.File("src/main/resources/log4j.properties");
//        org.apache.log4j.PropertyConfigurator(log4jfile.getAbsolutePath());
        
        logger.info("hello~!");
        
        if (logger.isDebugEnabled()) {
            logger.debug("hello~!");
        }
        
    }
    
}
