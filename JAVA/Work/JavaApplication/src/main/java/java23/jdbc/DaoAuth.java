package java23.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoAuth implements IAuth {
    private Connection conn = null;
    
    public DaoAuth(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public int getCount(ModelAuth auth) throws SQLException {
        int result = -1;
        
        //SQL 문장
        String query = "SELECT count(*) as total from auth where 1 = 1";
        
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
    public int getMaxAuthid() throws SQLException {
        int result = -1;
        
        String query = "SELECT max(authid) max from auth"; 
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
        
        String query = "SELECT * FROM auth ORDER BY authid ASC";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();
        }
        catch (SQLException e) {
            e.printStackTrace();
            
        }
        return rs;
    }
    
    @Override
    public ResultSet selectLike(ModelAuth auth) throws SQLException {
        ResultSet rs = null;
        
        String query = "SELECT * FROM auth where name like ?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, "%" + auth.getName() + "%");
            
            rs = stmt.executeQuery();
        }
        catch (SQLException e) {
            e.printStackTrace();
            
        }
        return rs;
    }
    
    @Override
    public ResultSet selectEqual(ModelAuth auth) throws SQLException {
        ResultSet rs = null;
        
        String query = "SELECT * FROM auth where name = ?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, auth.getName());
            
            rs = stmt.executeQuery();
        }
        catch (SQLException e) {
            e.printStackTrace();
            
        }
        return rs;
    }
    
    @Override
    public ResultSet selectDynamic(ModelAuth auth) throws SQLException {
        ResultSet rs = null;
        
        try {
            String query = "SELECT * FROM auth where 1 = 1";
            if (auth.getAuthid() != null) query += " and authid = ?";
            if (!auth.getName().isEmpty()) query += " and name = ?";
            if (!auth.getBirth().isEmpty()) query += " and birth = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            int c = 1;
            if (auth.getAuthid() != null) stmt.setInt(c++, auth.getAuthid());
            if (!auth.getName().isEmpty()) stmt.setString(c++, auth.getName());
            if (!auth.getBirth().isEmpty()) stmt.setString(c++, auth.getBirth());
            
            rs = stmt.executeQuery();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return rs;
    }
    
    @Override
    public int insertAuth(ModelAuth auth) throws SQLException {
        int rs = -1;
        
        try {
            String query = "INSERT INTO ";
            query += "auth(authid, name, birth) ";
            query += "VALUES(?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, auth.getAuthid());
            stmt.setString(2, auth.getName());
            stmt.setString(3, auth.getBirth());
            rs = stmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
            
        }
        return rs;
    }
    
    @Override
    public int updateAuth(ModelAuth whereauth, ModelAuth setauth) throws SQLException {
        int rs = -1;
        
        try {
            String query = "UPDATE auth SET name = ?, birth = ?";
            query += " WHERE name = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, setauth.getName());
            stmt.setString(2, setauth.getBirth());
            stmt.setString(3, whereauth.getName());
            rs = stmt.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
            
        }
        return rs;
    }
    
    @Override
    public int deleteAuth(ModelAuth auth) throws SQLException {
        int rs = -1;
        try {
            String query = "DELETE FROM auth";
            query += " WHERE name = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, auth.getName());
            rs = stmt.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
            
        }
        return rs;
    }
    
}
