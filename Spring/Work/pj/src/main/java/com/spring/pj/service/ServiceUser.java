package com.spring.pj.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.pj.inf.IDaoUser;
import com.spring.pj.inf.IServiceUser;
import com.spring.pj.model.ModelUser;

import java.util.*;

@Service
public class ServiceUser implements IServiceUser {
    
    // SLF4J Logging
    private static Logger logger = LoggerFactory.getLogger(ServiceUser.class);

    @Autowired
    private IDaoUser daouser;

    public ServiceUser() {
        super();
    }

    @Override
    public int insertUser(ModelUser user) {
        
        int result = -1;
        try {
            result = daouser.insertUser(user);
            //session.commit();
        } catch (Exception e) {
            logger.error("insertUser " + e.getMessage() );
        }
		
        return result;
    }

    @Override
    public ModelUser login(String userid, String passwd) {
        
        ModelUser result = null;
		
        try {
            result = daouser.login(userid, passwd);
        } catch (Exception e) {
            logger.error("login " + e.getMessage() );
        }
        return result;
    }

    @Override
    public int logout(String userid) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int updateUserInfo(ModelUser setValue, ModelUser whereValue) {
        int result = -1;
        try {
            result = daouser.updateUserInfo(setValue, whereValue);
        } catch (Exception e) {
            logger.error("updateUserInfo" + e.getMessage() );
        }
        return result;
    }

    @Override
    public int updatePasswd(String userid, String currentPasswd, String newPasswd) {
        int result = -1;
        try {
            result = daouser.updatePasswd( userid, currentPasswd, newPasswd);
        } catch (Exception e) {
            logger.error("updateUserInfo" + e.getMessage() );
        }
        return result;
    }

    @Override
    public int updateRetire(ModelUser whereValue) {
        int result = -1;
        try {
            result = daouser.updateRetire(whereValue);
        } catch (Exception e) {
            logger.error("updateUserInfo " + e.getMessage() );
        }
        return result;
    }

    @Override
    public ModelUser selectUserOne(ModelUser user) {
        ModelUser result = null;
        try {
            result = daouser.selectUserOne(user);
        } catch (Exception e) {
            logger.error("selectUserOne " + e.getMessage() );
        }
        return result;
    }

    @Override
    public List<ModelUser> selectUserList(ModelUser user) {
        List<ModelUser> result = null;
        try {
            result = daouser.selectUserList(user);
        } catch (Exception e) {
            logger.error("selectUserList " + e.getMessage() );
        }
        return result;
    }

    @Override
    public int checkuserid(String userid) {
        int result = -1;
        try {
            result = daouser.checkuserid(userid);
        } catch (Exception e) {
            logger.error("checkuserid " + e.getMessage() );
        }
        return result;
    }

    @Override
    public int checkpassword(String id, String cur_pw) {
        int result = -1;
        try {
            result = daouser.checkpassword(id, cur_pw);
        } catch (Exception e) {
            logger.error("checkpassword " + e.getMessage() );
        }
        return result;
    }
}
