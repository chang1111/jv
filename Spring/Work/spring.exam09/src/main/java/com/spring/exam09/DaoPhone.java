package com.spring.exam09;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DaoPhone implements IDaoPhone {
    
    @Autowired
    SqlSession session;

    @Override
    public List<ModelPhone> getPhoneList() {
        return session.selectList("mapperPhone.getPhoneList");
    }

    @Override
    public int insertPhone(ModelPhone phone) {
        return session.insert("mapperPhone.insertPhone", phone);
    }
}
