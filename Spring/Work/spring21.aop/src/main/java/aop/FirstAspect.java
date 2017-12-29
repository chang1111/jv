package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.ModelProduct;

public class FirstAspect {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    // before : 메서드 호출 전에 실행되는 advice.
    public void before(JoinPoint jp) {

        logger.debug("before ----> 메서드 호출되기 전");
        // jp.getSignature().getName() : 메서드명을 리턴
        // jp.getArgs().toString() : 매개변수 리턴
        logger.debug("before ----> 호출되는 메서드는" + jp.getSignature().getName());
        logger.debug("before ----> 매개변수는 " + jp.getArgs().toString());
    }
    
    // after : 메서드 호출 후 실행되는 advice
    // 반환 값이 없는 경우에 사용됨
    public void after() {
        
        logger.debug("after ----> 메서드 호출 후");
        logger.debug("after ----> 메서드 호출 후");
        logger.debug("after ----> 메서드 호출 후");
    }
    
    // afterReturning : 메서드 호출 후 실행되는 advice.
    // 반환 값이 있는 경우에 사용됨
    // ModelProduct product가 반환되는 값이다.
    public void afterReturning(JoinPoint jp, ModelProduct product) {
        
        logger.debug("afterReturning ----> 메서드 호출 후");
        logger.debug("afterReturning ----> 호출되는 메서드는" + jp.getSignature().getName());
        logger.debug("afterReturning ----> 매개변수는 " + jp.getArgs().toString());
    }
    
    //around 메서드 호출 전, 후 실행되는 advice.
    public Object around(ProceedingJoinPoint jp) throws Throwable {
        
        logger.debug("around ----> 메서드 호출 전");
        logger.debug("around ----> 메서드 호출 전");
        logger.debug("around ----> 메서드 호출 전");
        
        Object p = jp.proceed();
        
        logger.debug("around ----> 메서드 호출 후");
        logger.debug("around ----> 메서드 호출 후");
        logger.debug("around ----> 메서드 호출 후");
        
        return p;
    }
    
    // afterThrowing : 메서드 실행시 예외가 발생했을 때.
    public void afterThrowing(Throwable e) {
        
        logger.debug("afterThrowing ----> 메서드 실행 중 예외 발생");
        logger.debug("afterThrowing ----> exception value " + e.getMessage());
        logger.debug("afterThrowing ----> 메서드 실행 중 예외 발생");
    }
}
