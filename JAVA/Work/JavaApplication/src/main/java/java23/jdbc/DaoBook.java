package java23.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hamcrest.core.IsNull;

public class DaoBook implements IBook {
    private Connection conn = null;
    
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
        }
        catch (SQLException e) {
            e.printStackTrace();
            
        }
        return rs;
    }

    @Override
    public ResultSet selectLike(ModelBook book) throws SQLException {
        ResultSet rs = null;
        
        String query = "SELECT * FROM book where bookname like ?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, "%" + book.getBookname() + "%");
            
            rs = stmt.executeQuery();
        }
        catch (SQLException e) {
            e.printStackTrace();
            
        }
        return rs;
    }

    @Override
    public ResultSet selectEqual(ModelBook book) throws SQLException {
        ResultSet rs = null;
        
        String query = "SELECT * FROM book where bookname = ?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, book.getBookname());
            
            rs = stmt.executeQuery();
        }
        catch (SQLException e) {
            e.printStackTrace();
            
        }
        return rs;
    }

    @Override
    public ResultSet selectDynamic(ModelBook book) throws SQLException {
        ResultSet rs = null;
        
        try {
            String query = "SELECT * FROM book where 1 = 1";
            if (book.getBookid() != null) query += " and bookid = ?";
            if (!book.getBookname().isEmpty()) query += " and bookname = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            int c = 1;
            if (book.getBookid() != null) stmt.setInt(c++, book.getBookid());
            if (!book.getBookname().isEmpty()) stmt.setString(c++, book.getBookname());
            
            rs = stmt.executeQuery();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return rs;
    }

    @Override
    public int insertBook(ModelBook book) throws SQLException {
        int rs = -1;
        
        try {
            String query = "INSERT INTO ";
            query += "book(bookname, publisher, year, price, dtm, use_yn, authid) ";
            query += "VALUES(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, book.getBookname());
            stmt.setString(2, book.getPublisher());
            stmt.setString(3, book.getYear());
            stmt.setInt(4, book.getPrice());
            stmt.setDate(5, (java.sql.Date)book.getDtm());
//            stmt.setDate(5, null);
            stmt.setBoolean(6, book.getUse_yn());
            stmt.setInt(7, book.getAuthid());
            rs = stmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
            
        }
        return rs;
    }

    @Override
    public int updateBook(ModelBook wherebook, ModelBook setbook) throws SQLException {
        int rs = -1;
        
        try {
            String query = "UPDATE book SET year = ?, price = ?";
            query += " WHERE bookname = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, setbook.getYear());
            stmt.setInt(2, setbook.getPrice());
            stmt.setString(3, wherebook.getBookname());
            rs = stmt.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
            
        }
        return rs;
    }

    @Override
    public int deleteBook(ModelBook book) throws SQLException {
        int rs = -1;
        try {
            String query = "DELETE FROM book";
            query += " WHERE bookname = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, book.getBookname());
            rs = stmt.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
            
        }
        return rs;
    }
    
}
