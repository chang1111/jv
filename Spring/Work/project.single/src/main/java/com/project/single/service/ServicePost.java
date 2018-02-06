package com.project.single.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.single.inf.IDaoPost;
import com.project.single.inf.IServicePost;
import com.project.single.model.ModelAttachImage;
import com.project.single.model.ModelComments;
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
    public ModelPost getPostOne(int postno) {
        ModelPost result = null;
        
        try {
            result = dao.getPostOne(postno);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("getPostOne " + e.getMessage() );
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

    @Override
    public ModelAttachImage getAttachImage(Integer postno) {
        ModelAttachImage result = null;
        
        try {
            result = dao.getAttachImage(postno);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("getAttachImage " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int insertAttachImage(ModelAttachImage image) {
        int result = -1;
        
        try {
            result = dao.insertAttachImage(image);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("insertAttachImage " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int deleteAttachImage(ModelAttachImage image) {
        int result = -1;
        
        try {
            result = dao.deleteAttachImage(image);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("deleteAttachImage " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public ModelComments getComment(int commentno) {
        ModelComments result = null;
        
        try {
            result = dao.getComment(commentno);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("getComment " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public List<ModelComments> getCommentList(int postno) {
        List<ModelComments> result = null;
        
        try {
            result = dao.getCommentList(postno);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("getCommentList " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int insertComment(ModelComments comment) {
        int result = -1;
        
        try {
            result = dao.insertComment(comment);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("insertComment " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int updateComment(ModelComments updateValue, ModelComments searchValue) {
            int result = -1;
    
            try {
                result = dao.updateComment(updateValue, searchValue);
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("updateComment " + e.getMessage() );
            }
            
            return result;
    }

    @Override
    public int deleteComment(ModelComments comment) {
        int result = -1;
        
        try {
            result = dao.deleteComment(comment);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("deleteComment " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int addCountGood(int postno) {
        int result = -1;
        
        try {
            result = dao.addCountGood(postno);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("addCountGood " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int addCountBad(int postno) {
        int result = -1;
        
        try {
            result = dao.addCountBad(postno);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("addCountBad " + e.getMessage() );
        }
        
        return result;
    }
}
