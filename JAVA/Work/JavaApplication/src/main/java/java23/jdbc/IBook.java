package java23.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IBook {
    int getCount(ModelBook book);
    int getMaxBookid() throws SQLException;
    ResultSet selectAll() throws SQLException;
    ResultSet selectLike(ModelBook book) throws SQLException;
    ResultSet selectEqual(ModelBook book) throws SQLException;
    ResultSet selectDynamic(ModelBook book) throws SQLException;
    int insertBook(ModelBook book) throws SQLException;
    int updateBook(ModelBook wherebook, ModelBook setbook) throws SQLException;
    int deleteBook(ModelBook book) throws SQLException;
}
