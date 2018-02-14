package com.spring61.rest.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Repository;

import com.spring61.rest.inf.*;
import com.spring61.rest.model.*;

import java.util.*;

@Repository("daouser")
public class DaoUser implements IUser {

    @Autowired
    @Qualifier("sqlSession")
    private SqlSession session;    
    
    @Override
    public int insertUser(ModelUser user) {
        return session.insert("mapper.mapperUser.insertUser", user);   
    }

    @Override
    public ModelUser login(String userid, String passwd) {
        Map<String, Object> map = new HashMap<>(); 
        map.put("userid"  ,    userid);
        map.put("passwd",      passwd);
        return session.selectOne("mapper.mapperUser.login", map);
    }

    @Override
    public int logout(String userid) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int updateUserInfo(ModelUser setValue, ModelUser whereValue) {
        
        Map<String, ModelUser> map = new HashMap<String, ModelUser>(); 
        map.put("setValue"  ,      setValue);
        map.put("whereValue",      whereValue);

        return session.update("mapper.mapperUser.updateUserInfo", map);
    }

    @Override
    public int updatePasswd(String userid, String currentPasswd, String newPasswd) {
        
        Map<String, Object> map = new HashMap<>();
        map.put("userid"       , userid       );
        map.put("currentPasswd", currentPasswd); 
        map.put("newPasswd"    , newPasswd    );
        return session.update("mapper.mapperUser.updatePasswd", map);
    }

    @Override
    public int updateRetire(ModelUser user) {
        return session.delete("mapper.mapperUser.updateRetire", user);
    }

    @Override
    public ModelUser selectUserOne(ModelUser user) {
        return session.selectOne("mapper.mapperUser.selectUserOne", user);
    }

    @Override
    public List<ModelUser> selectUserList(ModelUser user) {
        return session.selectList("mapper.mapperUser.selectUserList", user);
    }

    @Override
    public int checkuserid(String userid) {
        return session.selectOne("mapper.mapperUser.checkuserid", userid);
    }

    @Override
    public int checkpassword(String id, String curpw) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("id", id   );
        map.put("pw", curpw);
        return session.selectOne("mapper.mapperUser.checkpassword", map);
    }
    
}
