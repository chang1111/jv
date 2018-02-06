package com.project.single.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.single.inf.IDaoPost;
import com.project.single.model.ModelAttachImage;
import com.project.single.model.ModelComments;
import com.project.single.model.ModelPost;

@Repository
public class DaoPost implements IDaoPost {
    
    @Autowired
    SqlSession session;
    
    @Override
    public List<ModelPost> getPostList(int start, int end) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("start", start);
        map.put("end", end);
        return session.selectList("mapperPost.getPostList", map);
    }
    
    public ModelPost getPostOne(int postno) {
        return session.selectOne("mapperPost.getPostOne", postno);
    }
    
    @Override
    public int insertPost(ModelPost post) {
        session.insert("mapperPost.insertPost", post);
        return post.getPostno();
    }
    
    @Override
    public int deletePost(ModelPost post) {
        return session.delete("mapperPost.deletePost", post);
    }

    @Override
    public ModelAttachImage getAttachImage(Integer postno) {
        return session.selectOne("mapperPost.getAttachImage", postno);
    }

    @Override
    public int insertAttachImage(ModelAttachImage image) {
        return session.insert("mapperPost.insertAttachImage", image);
    }

    @Override
    public int deleteAttachImage(ModelAttachImage image) {
        return session.insert("mapperPost.deleteAttachImage", image);
    }

    @Override
    public ModelComments getComment(int commentno) {
        return session.selectOne("mapperPost.getComment", commentno);
    }

    @Override
    public List<ModelComments> getCommentList(int postno) {
        return session.selectList("mapperPost.getCommentList", postno);
    }

    @Override
    public int insertComment(ModelComments comment) {
        session.insert("mapperPost.insertComment", comment);
        return comment.getCommentno();
    }

    @Override
    public int updateComment(ModelComments updateValue,
            ModelComments searchValue) {
        Map<String, ModelComments> map = new HashMap<String, ModelComments>();
        map.put("updateValue", updateValue);
        map.put("searchValue", searchValue);
        return session.update("mapperPost.updateComment", map);
    }

    @Override
    public int deleteComment(ModelComments comment) {
        return session.delete("mapperPost.deleteComment", comment);
    }

    @Override
    public int addCountGood(int postno) {
        return session.update("mapperPost.addCountGood", postno);
    }

    @Override
    public int addCountBad(int postno) {
        return session.update("mapperPost.addCountBad", postno);
    }
}
