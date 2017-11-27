package board.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import board.inf.IServiceUser;
import board.inf.IUser;
import board.model.ModelUser;

@Service("serviceuser")
public class ServiceUser implements IServiceUser {
    
    private static Logger logger = LoggerFactory.getLogger(ServiceUser.class);
    
    @Autowired
    @Qualifier("daouser")
    private IUser dao;
    
    @Override
    public int insertUser(ModelUser user) throws Exception {
        int result = -1;
        try {
            result = dao.insertUser(user);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error( "insertUser " + e.getMessage() );
        }
        return result;
    }
    
    @Override
    public List<ModelUser> login(ModelUser user) throws Exception {
        List<ModelUser> result = null;
        try {
            result = dao.login(user);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error( "login " + e.getMessage() );
        }
        return result;
    }
    
    @Override
    public int logout(String name) throws Exception {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public int updateUserInfo(ModelUser searchValue, ModelUser updateValue)
            throws Exception {
        int result = -1;
        try {
            result = dao.updateUserInfo(searchValue, updateValue);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error( "updateUser " + e.getMessage() );
        }
        return result;
    }
    
    @Override
    public int updatePasswd(String userid, String currentPasswd,
            String newPasswd) throws Exception {
        int result = -1;
        try {
            result = dao.updatePasswd(userid, currentPasswd, newPasswd);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error( "updatePasswd " + e.getMessage() );
        }
        return result;
    }
    
    @Override
    public int deleteUser(ModelUser user) throws Exception {
        int result = -1;
        try {
            result = dao.deleteUser(user);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error( "deleteUser " + e.getMessage() );
        }
        return result;
    }
    
    @Override
    public List<ModelUser> selectUserOne(ModelUser user) throws Exception {
        List<ModelUser> result = null;
        try {
            result = dao.selectUserOne(user);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error( "selectUserOne " + e.getMessage() );
        }
        return result;
    }
    
    @Override
    public List<ModelUser> selectUserList(ModelUser user) throws Exception {
        List<ModelUser> result = null;
        try {
            result = dao.selectUserList(user);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error( "selectUserList " + e.getMessage() );
        }
        return result;
    }
    
    @Override
    public int checkuserid(String userid) throws Exception {
        int result = 0;
        try {
            result = dao.checkuserid(userid);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error( "checkuserid " + e.getMessage() );
        }
        return result;
    }
    
}
