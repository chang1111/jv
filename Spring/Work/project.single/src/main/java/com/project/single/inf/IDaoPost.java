package com.project.single.inf;

import java.util.List;

import com.project.single.model.ModelAttachImage;
import com.project.single.model.ModelPost;

public interface IDaoPost {
    
    List<ModelPost> getPostList(int start, int end);
    
    int insertPost(ModelPost post);
    
    int deletePost(ModelPost post);
    
    ModelAttachImage getAttachImage(Integer postno);
    
    int insertAttachImage(ModelAttachImage image);
    
    int deleteAttachImage(ModelAttachImage image);
}
