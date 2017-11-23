package java24.mybatis.inf;

import java.util.List;

import java24.mybatis.model.ModelAuth;

public interface IAuth {
    int getCount(ModelAuth auth) throws Exception;
    int getMaxAuthid() throws Exception;
    List<ModelAuth> selectAll(ModelAuth auth) throws Exception;
    List<ModelAuth> selectLike(ModelAuth auth) throws Exception;
    List<ModelAuth> selectEqual(ModelAuth auth) throws Exception;
    int insertAuth(ModelAuth auth) throws Exception;
    int updateAuth(ModelAuth whereauth, ModelAuth setauth) throws Exception;
    int deleteAuth(ModelAuth auth) throws Exception;
}
