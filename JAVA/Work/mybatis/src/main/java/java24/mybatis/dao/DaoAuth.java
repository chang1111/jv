package java24.mybatis.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java24.mybatis.inf.IAuth;
import java24.mybatis.model.ModelAuth;

@Repository("daoauth")
public class DaoAuth implements IAuth {

    @Autowired
    @Qualifier("sqlSession")
    private SqlSession session;
    
    @Override
    public int getCount(ModelAuth auth) throws Exception {
        int result = -1;
        result = session.selectOne("mapper.mapperAuth.getCount", auth);
        return result;
    }

    @Override
    public int getMaxAuthid() throws Exception {
        int result = -1;
        result = session.selectOne("mapper.mapperAuth.getMaxAuthid");
        return result;
    }

    @Override
    public List<ModelAuth> selectAll(ModelAuth auth) throws Exception {
        List<ModelAuth> result = null; 
        result = session.selectList("mapper.mapperAuth.selectAll", auth);
        return result;
    }

    @Override
    public List<ModelAuth> selectLike(ModelAuth auth) throws Exception {
        List<ModelAuth> result = null;
        result = session.selectList("mapper.mapperAuth.selectLike", auth);
        return result;
    }

    @Override
    public List<ModelAuth> selectEqual(ModelAuth auth) throws Exception {
        List<ModelAuth> result = null;
        result = session.selectList("mapper.mapperAuth.selectEqual", auth);
        return result;
    }

    @Override
    public int insertAuth(ModelAuth auth) throws Exception {
      int result = -1;
      result = session.insert("mapper.mapperAuth.insertAuth", auth);
      
      return result;
    }

    @Override
    public int updateAuth(ModelAuth whereauth, ModelAuth setauth)
            throws Exception {
        int result = -1;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("whereauth", whereauth);
        map.put("setauth", setauth);
        result = session.update("mapper.mapperAuth.updateAuth", map);
        return result;
    }

    @Override
    public int deleteAuth(ModelAuth auth) throws Exception {
        int result = -1;
        result = session.delete("mapper.mapperAuth.deleteAuth", auth);
        return result;
    }
    
}
