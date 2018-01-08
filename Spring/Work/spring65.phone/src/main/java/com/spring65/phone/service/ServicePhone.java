package com.spring65.phone.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring65.phone.inf.IDaoPhone;
import com.spring65.phone.inf.IServicePhone;
import com.spring65.phone.model.ModelPhone;

@Service("servicephone")
public class ServicePhone implements IServicePhone {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    @Qualifier("daophone")
    private IDaoPhone dao;

    @Override
    public ModelPhone getPhoneOne(String name) {
        ModelPhone result = null;
        try {
            result = dao.getPhoneOne(name);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error( "getPhoneOne " + e.getMessage() );
        }

        return result;
    }

    @Override
    public List<ModelPhone> getPhoneList() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int insertPhone(ModelPhone phone) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int insertPhone(List<ModelPhone> phones) {
        // TODO Auto-generated method stub
        return 0;
    }
}
