package com.project.single;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.single.inf.IServicePost;
import com.project.single.model.ModelPost;

public class TestService {
    
    private static IServicePost service = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml");
        service = context.getBean(IServicePost.class);
    }
    
    @Test
    public void testGetPostList() {
        List<ModelPost> result = service.getPostList(1, 5);
        
        assertNotNull(result);
        assertEquals(result.get(0).getPostno(), new Integer(23));
        assertEquals(result.get(0).getAuthor(), "test 23");
        assertEquals(result.get(0).getContent(), "test 23");
    }
    
    @Test
    public void testInsertPost() {
        ModelPost post = new ModelPost();
        post.setAuthor("test 24");
        post.setContent("test 24");
        
        int result = service.insertPost(post);
        
        assertEquals(result, 1);
    }
    
    @Test
    public void testDeletePost() {
        fail("Not yet implemented");
    }
}
