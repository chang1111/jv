package java23.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceBook implements IServiceBook {
    
    @Override
    public int getCount(ModelBook book) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public int getMaxBookid() throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public ResultSet selectAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public ResultSet selectLike(ModelBook book) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public ResultSet selectEqual(ModelBook book) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public ResultSet selectDynamic(ModelBook book) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public int insertBook(ModelBook book) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public int updateBook(ModelBook wherebook, ModelBook setbook)
            throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public int deleteBook(ModelBook book) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public int transCommit(ModelBook b1, ModelBook b2) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public int transRollback(ModelBook b1, ModelBook b2) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
