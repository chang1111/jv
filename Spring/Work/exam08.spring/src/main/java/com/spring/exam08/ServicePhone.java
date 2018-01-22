package com.spring.exam08;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ServicePhone implements IServicePhone {
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    IDaoPhone dao;

    @Override
    public ModelPhone getPhoneOne(String name) {
        ModelPhone result = null;
        try {
            result = dao.getPhoneOne(name);
        } catch (Exception e) {
            logger.error("getPhoneOne" + e.getMessage());
            
        }
        return result;
    }

    @Override
    public List<ModelPhone> getPhoneList() {
        List<ModelPhone> result = null;
        try {
            result = dao.getPhoneList();
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return result;
    }

    @Override
    public int insertPhone(ModelPhone phone) {
        int result = -1;
        try {
            result = dao.insertPhone(phone);
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return result;
    }

    @Override
    public int insertPhoneList(List<ModelPhone> phones) {
        int result = -1;
        try {
            result = dao.insertPhoneList(phones);
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return result;
    }
}
