package com.spring.exam08;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DaoPhone implements IDaoPhone {
    
    @Autowired
    SqlSession session;

    @Override
    public ModelPhone getPhoneOne(String name) {
        return session.selectOne("mapperPhone.getPhoneOne", name);
    }

    @Override
    public List<ModelPhone> getPhoneList() {
        return session.selectList("mapperPhone.getPhoneList");
    }

    @Override
    public int insertPhone(ModelPhone phone) {
        return session.insert("mapperPhone.insertPhone", phone);
    }

    @Override
    public int insertPhoneList(List<ModelPhone> phones) {
        return session.insert("mapperPhone.insertPhoneList", phones);
    }
}
