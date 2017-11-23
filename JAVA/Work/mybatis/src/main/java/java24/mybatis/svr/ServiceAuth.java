package java24.mybatis.svr;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java24.mybatis.inf.IAuth;
import java24.mybatis.inf.IServiceAuth;
import java24.mybatis.model.ModelAuth;

@Service("serviceauth")
public class ServiceAuth implements IServiceAuth {
    
    private static Logger logger = LoggerFactory.getLogger(ServiceBook.class);


    @Autowired
    @Qualifier("daoauth")
    private IAuth dao;
    
    @Override
    public int getCount(ModelAuth auth) throws Exception {
        int result = -1;
        try {
            result = dao.getCount(auth);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error( "getCount " + e.getMessage() );
        }
        return result;
    }

    @Override
    public int getMaxAuthid() throws Exception {
        int result = -1;
        try {
            result = dao.getMaxAuthid();
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error( "getMaxAuthid " + e.getMessage() );
        }
        return result;
    }

    @Override
    public List<ModelAuth> selectAll(ModelAuth auth) throws Exception {
        List<ModelAuth> result = null;
        try {
            result = dao.selectAll(auth);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error( "selectAll " + e.getMessage() );
        }
        return result;
    }

    @Override
    public List<ModelAuth> selectLike(ModelAuth auth) throws Exception {
        List<ModelAuth> result = null;
        try {
            result = dao.selectLike(auth);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error( "selectLike " + e.getMessage() );
        }
        return result;
    }

    @Override
    public List<ModelAuth> selectEqual(ModelAuth auth) throws Exception {
        List<ModelAuth> result = null;
        try {
            result = dao.selectEqual(auth);
        }
        catch (Exception e) {
            logger.error( "selectEqual " + e.getMessage() );
        }
        return result;
    }

    @Override
    public int insertAuth(ModelAuth auth) throws Exception {
        int result = -1;
        try {
            result = dao.insertAuth(auth);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error( "insertAuth " + e.getMessage() );
        }
        return result;
    }

    @Override
    public int updateAuth(ModelAuth whereauth, ModelAuth setauth)
            throws Exception {
        int result = -1;
        try {
            result = dao.updateAuth(whereauth, setauth);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error( "updateAuth " + e.getMessage() );
        }
        return result;
    }

    @Override
    public int deleteAuth(ModelAuth auth) throws Exception {
        int result = -1;
        try {
            result = dao.deleteAuth(auth);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error( "deleteAuth " + e.getMessage() );
        }
        return result;
    }
    
}
