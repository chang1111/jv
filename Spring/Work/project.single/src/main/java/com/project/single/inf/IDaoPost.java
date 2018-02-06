package com.project.single.inf;

import java.util.List;

import com.project.single.model.ModelAttachImage;
import com.project.single.model.ModelComments;
import com.project.single.model.ModelPost;

public interface IDaoPost {
    
    List<ModelPost> getPostList(int start, int end);
    
    ModelPost getPostOne(int postno);
    
    int insertPost(ModelPost post);
    
    int deletePost(ModelPost post);
    
    ModelAttachImage getAttachImage(Integer postno);
    
    int insertAttachImage(ModelAttachImage image);
    
    int deleteAttachImage(ModelAttachImage image);
    
    ModelComments getComment(int commentno);
    
    List<ModelComments> getCommentList(int postno);
    
    int insertComment(ModelComments comment);
    
    int updateComment(ModelComments updateValue, ModelComments searchValue);
    
    int deleteComment(ModelComments comment);
    
    int addCountGood(int postno);
    
    int addCountBad(int postno);
}
