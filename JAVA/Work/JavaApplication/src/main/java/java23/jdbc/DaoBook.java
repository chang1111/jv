package java23.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoBook implements IBook {
    private Connection conn = null;
    
    public DaoBook() {
        
    }
    
    public DaoBook(Connection conn) {
        this.conn = conn;
    }

    @Override
    public int getCount(ModelBook book) {
        int result = -1;
        
        //SQL 문장
        String query = "SELECT count(*) as total from book where 1 = 1";
        
        try {
            //문장 객체 생성
            PreparedStatement stmt = conn.prepareStatement(query);
            
            //SQL 문장 실행
            ResultSet rs = stmt.executeQuery();
            
            rs.next(); // 커서 이동. ResultSet 첫번째 로우로
            result = rs.getInt("total");
        }
        catch (SQLException e) {
            e.printStackTrace();
            
        }
        
        return result;
    }

    @Override
    public int getMaxBookid() throws SQLException {
        int result = -1;
        
        String query = "SELECT max(Bookid) max from book"; 
        try {
            //문장 객체 생성
            PreparedStatement stmt = conn.prepareStatement(query);
            
            //SQL 문장 실행
            ResultSet rs = stmt.executeQuery();
            
            rs.next(); // 커서 이동. ResultSet 첫번째 로우로
            result = rs.getInt("max");
        }
        catch (SQLException e) {
            e.printStackTrace();
            
        }
        return result;
    }

    @Override
    public ResultSet selectAll() throws SQLException {
        ResultSet rs = null;
        
        String query = "SELECT * FROM book ORDER BY bookid ASC";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return rs;
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
    
}
