package example.com.prj.inf;

import java.util.List;

import example.com.prj.model.ModelAttachImage;
import example.com.prj.model.ModelComments;
import example.com.prj.model.ModelPost;

public interface IPost {
    
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
