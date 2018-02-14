package com.spring61.rest.inf;

import java.util.List;

import com.spring61.rest.model.ModelUser;

public interface IUser {
    
    int logout(String userid);
    
    ModelUser login(String userid, String passwd);
    
    // id 중복 확인시 사용되는 메서드
    int checkuserid(String userid);
    
    int updatePasswd(String userid, String currentPasswd, String newPasswd);

    List<ModelUser> selectUserList(ModelUser user);
    
    ModelUser selectUserOne(ModelUser user);
    
    int insertUser(ModelUser user);
    
    int updateUserInfo(ModelUser setValue, ModelUser whereValue);
    
    int updateRetire(ModelUser user);
    
    // password 확인. 왜냐하면 패스워드는 암호화 되기 때문에...
    int checkpassword( String id, String curpw);
}
