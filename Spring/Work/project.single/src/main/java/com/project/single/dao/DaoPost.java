package com.project.single.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.single.inf.IDaoPost;
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
    
    @Override
    public int insertPost(ModelPost post) {
        return session.insert("mapperPost.insertPost", post);
    }
    
    @Override
    public int deletePost(ModelPost post) {
        return session.delete("mapperPost.deletePost", post);
    }
}
