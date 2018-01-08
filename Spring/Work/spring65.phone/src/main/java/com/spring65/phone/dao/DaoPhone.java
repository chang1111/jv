package com.spring65.phone.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring65.phone.inf.IDaoPhone;
import com.spring65.phone.model.ModelPhone;

@Repository("daophone")
public class DaoPhone implements IDaoPhone {
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    SqlSession session;

    @Override
    public ModelPhone getPhoneOne(String name) {
        
        return session.selectOne("mapper.mapperPhone.getPhoneOne", name);
    }

    @Override
    public List<ModelPhone> getPhoneList() {
        
        return session.selectList("mapper.mapperPhone.getPhoneList");
    }

    @Override
    public int insertPhone(ModelPhone phone) {
        
        return session.insert("mapper.mapperPhone.insertPhone", phone);
    }

    @Override
    public int insertPhone(List<ModelPhone> phones) {
        
        return session.insert("mapper.mapperPhone.insertPhoneList", phones);
    }
}
