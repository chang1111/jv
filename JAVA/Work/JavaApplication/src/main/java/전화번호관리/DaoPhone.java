package 전화번호관리;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoPhone implements IPhone {
    private Connection conn = null;
    
    public DaoPhone(Connection conn) {
        this.conn = conn;
    }

    @Override
    public int getCount(ModelPhone phone) throws SQLException {
        int result = -1;
        
        //SQL 문장
        String query = "SELECT count(*) as total from phone where 1 = 1";
        
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
    public ResultSet selectAll() throws SQLException {
        ResultSet rs = null;
        
        String query = "SELECT * FROM phone";
        
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
    public ResultSet selectLike(ModelPhone phone) throws SQLException {
        ResultSet rs = null;
        
        String query = "SELECT * FROM phone where name like ?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, "%" + phone.getName() + "%");
            
            rs = stmt.executeQuery();
        }
        catch (SQLException e) {
            e.printStackTrace();
            
        }
        return rs;
    }

    @Override
    public ResultSet selectEqual(ModelPhone phone) throws SQLException {
        ResultSet rs = null;
        
        String query = "SELECT * FROM phone where name = ?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, phone.getName());
            
            rs = stmt.executeQuery();
        }
        catch (SQLException e) {
            e.printStackTrace();
            
        }
        return rs;
    }

    @Override
    public ResultSet selectDynamic(ModelPhone phone) throws SQLException {
        ResultSet rs = null;
        
        try {
            String query = "SELECT * FROM phone where 1 = 1";
            if (!phone.getName().isEmpty()) query += " and name = ?";
            if (!phone.getPhoneNumber().isEmpty()) query += " and phonenumber = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            int c = 1;
            if (!phone.getName().isEmpty()) stmt.setString(c++, phone.getName());
            if (!phone.getPhoneNumber().isEmpty()) stmt.setString(c++, phone.getPhoneNumber());
            
            rs = stmt.executeQuery();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return rs;
    }

    @Override
    public int insertPhone(ModelPhone phone) throws SQLException {
        int rs = -1;
        
        try {
            String query = "INSERT INTO ";
            query += "phone(name, phonenumber, job) ";
            query += "VALUES(?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, phone.getName());
            stmt.setString(2, phone.getPhoneNumber());
            stmt.setString(3, "일반");
            rs = stmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
            
        }
        return rs;
    }

    @Override
    public int updatePhone(ModelPhone wherephone, ModelPhone setphone)
            throws SQLException {
        int rs = -1;
        
        try {
            String query = "UPDATE phone SET name = ?, phonenumber = ?";
            query += " WHERE name = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, setphone.getName());
            stmt.setString(2, setphone.getPhoneNumber());
            stmt.setString(3, wherephone.getName());
            rs = stmt.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
            
        }
        return rs;
    }

    @Override
    public int deletePhone(ModelPhone phone) throws SQLException {
        int rs = -1;
        try {
            String query = "DELETE FROM phone";
            query += " WHERE name = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, phone.getName());
            rs = stmt.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
            
        }
        return rs;
    }
    
}
