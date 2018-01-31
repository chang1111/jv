package com.project.single.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.single.inf.IDaoPost;
import com.project.single.inf.IServicePost;
import com.project.single.model.ModelPost;

@Service
public class ServicePost implements IServicePost {
    
    private static Logger logger = LoggerFactory.getLogger(ServicePost.class);
    
    @Autowired
    private IDaoPost dao;
    
    @Override
    public List<ModelPost> getPostList(int start, int end) {
        List<ModelPost> result = null;
        
        try {
            result = dao.getPostList(start, end);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("getPostList " + e.getMessage() );
        }
        
        return result;
    }
    
    @Override
    public int insertPost(ModelPost post) {
        int result = -1;
        
        try {
            result = dao.insertPost(post);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("insertPost " + e.getMessage() );
        }
        
        return result;
    }
    
    @Override
    public int deletePost(ModelPost post) {
        int result = -1;
        
        try {
            result = dao.deletePost(post);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("deletePost " + e.getMessage() );
        }
        
        return result;
    }
}
