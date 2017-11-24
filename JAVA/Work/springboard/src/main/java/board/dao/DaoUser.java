package board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import board.inf.IUser;
import board.model.ModelUser;

@Repository("daouser")
public class DaoUser implements IUser {
    
    @Autowired
    @Qualifier("sqlSession")
    private SqlSession session;
    @Override
    public int insertUser(ModelUser user) throws Exception {
        int result = -1;
        result = session.insert("mapper.mapperUser.insertUser", user);
        return result;
    }
    
    @Override
    public List<ModelUser> login(ModelUser user) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public int logout(String name) throws Exception {
        return 0;
    }
    
    @Override
    public int updateUserInfo(ModelUser searchValue, ModelUser updateValue)
            throws Exception {
        int result = -1;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("updateValue", updateValue);
        map.put("searchValue", searchValue);
        result = session.update("mapper.mapperUser.updateUserInfo", map);
        return result;
    }
    
    @Override
    public int updatePasswd(String userid, String currentPasswd,
            String newPasswd) throws Exception {
        int result = -1;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userid", userid);
        map.put("currentPasswd", currentPasswd);
        map.put("newPasswd", newPasswd);
        result = session.update("mapper.mapperUser.updatePasswd", map);
        return result;
    }
    
    @Override
    public int deleteUser(ModelUser user) throws Exception {
        int result = -1;
        result = session.delete("mapper.mapperUser.deleteUser", user);
        return result;
    }
    
    @Override
    public List<ModelUser> selectUserOne(ModelUser user) throws Exception {
        List<ModelUser> result = null;
        result = session.selectList("mapper.mapperUser.selectUserOne",user);
        return result;
    }
    
    @Override
    public List<ModelUser> selectUserList(ModelUser user) throws Exception {
        List<ModelUser> result = null;
        result = session.selectList("mapper.mapperUser.selectUserList",user);
        return result;
    }
    
    @Override
    public int checkuserid(String userid) throws Exception {
        int result = -1;
        result = session.selectOne("mapper.mapperUser.checkuserid", userid);
        return result;
    }
    
}
