package board.inf;

import java.util.List;

import board.model.ModelUser;

public interface IUser {
    int insertUser(ModelUser user) throws Exception;
    List<ModelUser> login(ModelUser user) throws Exception;
    int logout(String name) throws Exception;
    int updateUserInfo(ModelUser searchValue, ModelUser updateValue) throws Exception;
    int updatePasswd(String userid, String currentPasswd, String newPasswd) throws Exception;
    int deleteUser(ModelUser user) throws Exception;
    List<ModelUser> selectUserOne(ModelUser user) throws Exception;
    List<ModelUser> selectUserList(ModelUser user) throws Exception;
    int checkuserid(String userid) throws Exception;
}
