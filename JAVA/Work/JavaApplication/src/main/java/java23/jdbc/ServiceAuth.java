package java23.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceAuth implements IAuth {
    private Connection conn = null;
    
    public ServiceAuth() {
        conn = DBConnect.makeConnection();
    }

    @Override
    public int getCount(ModelAuth auth) throws SQLException {
        int rs = -1;
        
        try {
            conn.setAutoCommit(false);
            DaoAuth dao = new DaoAuth(conn);
            rs = dao.getCount(auth);
            conn.commit();
        }
        catch (SQLException e) {
            e.printStackTrace();
            conn.rollback();
        }
        return rs;
    }

    @Override
    public int getMaxAuthid() throws SQLException {
        int rs = -1;
        
        try {
            conn.setAutoCommit(false);
            DaoAuth dao = new DaoAuth(conn);
            rs = dao.getMaxAuthid();
            conn.commit();
        }
        catch (SQLException e) {
            e.printStackTrace();
            conn.rollback();
        }
        return rs;
    }

    @Override
    public ResultSet selectAll() throws SQLException {
        ResultSet rs = null;
        
        try {
            conn.setAutoCommit(false);
            DaoAuth dao = new DaoAuth(conn);
            rs = dao.selectAll();
            conn.commit();
        }
        catch (SQLException e) {
            e.printStackTrace();
            conn.rollback();
        }
        return rs;
    }

    @Override
    public ResultSet selectLike(ModelAuth auth) throws SQLException {
        ResultSet rs = null;
        
        try {
            conn.setAutoCommit(false);
            DaoAuth dao = new DaoAuth(conn);
            rs = dao.selectLike(auth);
            conn.commit();
        }
        catch (SQLException e) {
            e.printStackTrace();
            conn.rollback();
        }
        return rs;
    }

    @Override
    public ResultSet selectEqual(ModelAuth auth) throws SQLException {
        ResultSet rs = null;
        
        try {
            conn.setAutoCommit(false);
            DaoAuth dao = new DaoAuth(conn);
            rs = dao.selectEqual(auth);
            conn.commit();
        }
        catch (SQLException e) {
            e.printStackTrace();
            conn.rollback();
        }
        return rs;
    }

    @Override
    public ResultSet selectDynamic(ModelAuth auth) throws SQLException {
        ResultSet rs = null;
        
        try {
            conn.setAutoCommit(false);
            DaoAuth dao = new DaoAuth(conn);
            rs = dao.selectDynamic(auth);
            conn.commit();
        }
        catch (SQLException e) {
            e.printStackTrace();
            conn.rollback();
        }
        return rs;
    }

    @Override
    public int insertAuth(ModelAuth auth) throws SQLException {
        int rs = -1;
        
        try {
            conn.setAutoCommit(false);
            DaoAuth dao = new DaoAuth(conn);
            rs = dao.insertAuth(auth);
            conn.commit();
        }
        catch (SQLException e) {
            e.printStackTrace();
            conn.rollback();
        }
        return rs;
    }

    @Override
    public int updateAuth(ModelAuth whereauth, ModelAuth setauth) throws SQLException {
        int rs = -1;
        
        try {
            conn.setAutoCommit(false);
            DaoAuth dao = new DaoAuth(conn);
            rs = dao.updateAuth(whereauth, setauth);
            conn.commit();
        }
        catch (SQLException e) {
            e.printStackTrace();
            conn.rollback();
        }
        return rs;
    }

    @Override
    public int deleteAuth(ModelAuth auth) throws SQLException {
        int rs = -1;
        
        try {
            conn.setAutoCommit(false);
            DaoAuth dao = new DaoAuth(conn);
            rs = dao.deleteAuth(auth);
            conn.commit();
        }
        catch (SQLException e) {
            e.printStackTrace();
            conn.rollback();
        }
        return rs;
    }
    
}
