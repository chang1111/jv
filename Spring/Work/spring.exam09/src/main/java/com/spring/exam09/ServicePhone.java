package com.spring.exam09;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicePhone implements IServicePhone {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    IDaoPhone dao;

    @Override
    public List<ModelPhone> getPhoneList() {
        List<ModelPhone> result = null;
        try {
            result = dao.getPhoneList();
        } catch (Exception e) {
            logger.error("getPhoneList" + e.getMessage());
        }
        return result;
    }

    @Override
    public int insertPhone(ModelPhone phone) {
        int result = -1;
        try {
            result = dao.insertPhone(phone);
        } catch (Exception e) {
            logger.error("insertPhone" + e.getMessage());
        }
        return result;
    }
}
