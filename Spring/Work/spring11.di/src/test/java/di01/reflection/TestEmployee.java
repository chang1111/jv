package di01.reflection;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.BeforeClass;
import org.junit.Test;

import di01.model.Employee;

public class TestEmployee {
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }
    
    @Test
    public void test_make_instance_with_new() {
        di01.model.Employee emp1 = new di01.model.Employee();
        emp1.setAddress("emp1 address");
        emp1.setName("emp1 name");
        emp1.setRrn("emp1 rrn");
        emp1.setSalary(10000);
        
        di01.model.Employee emp2 = new di01.model.Employee("emp2 name", "emp2 address", 1000, "emp2 rrn");
        
        assertEquals("emp1 address", emp1.getAddress());
        assertEquals("emp1 name", emp1.getName());
        assertEquals("emp1 rrn", emp1.getRrn());
        assertEquals(10000, emp1.getSalary());
        assertEquals("emp2 address", emp2.getAddress());
        assertEquals("emp2 name", emp2.getName());
        assertEquals("emp2 rrn", emp2.getRrn());
        assertEquals(1000, emp2.getSalary());
    }
    @Test
    public void test_make_instance_with_reflation() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        // reflection을 이용해서 인스턴스 만들기
        // reflection으로 new di01.model.Employee("emp2 name", "emp2 address", 1000, "emp2 rrn") 코드 만들기
        Class klass = Class.forName("di01.model.Employee"); // class 로딩
        
        // 생성자 메서드의 매개변수 타입 선언.
        Class[] paramTypes = {String.class, String.class, int.class, String.class};
        
        // 매개변수 값 설정
        Object[] objs = {"emp2 name", "emp2 address", 1000, "emp2 rrn"};
        
        // 생성자 메서드 가져오기
        java.lang.reflect.Constructor cons = klass.getConstructor(paramTypes);
        
        // 인스턴스 만들기
        Object instance = cons.newInstance(objs);
        
        // 실행해서 결과 출력
        System.out.println(instance.toString());
        assertEquals("emp2 address", ((di01.model.Employee)instance).getAddress());
        
        /*
         * setter를 이용하여 필드값 바꾸기
         */
        java.lang.reflect.Method m = klass.getMethod("setName", String.class);
        
        // 매개변수 값 설정
        Object[] params = {"hello"};
        
        // 매서드 호출
        m.invoke(instance, params); // Employee.setName("hello"); 가 실행됨
        assertEquals("hello", ((di01.model.Employee)instance).getName());
        
        /*
         * setter를 이용하여 필드값 바꾸기
         */
        m = klass.getMethod("getName");
        Object result = m.invoke(instance);
        assertEquals("hello", (String)result);
    }
    
}
