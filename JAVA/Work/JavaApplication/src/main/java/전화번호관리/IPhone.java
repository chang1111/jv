package 전화번호관리;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IPhone {
    int getCount(ModelPhone phone) throws SQLException;
    ResultSet selectAll() throws SQLException;
    ResultSet selectLike(ModelPhone phone) throws SQLException;
    ResultSet selectEqual(ModelPhone phone) throws SQLException;
    ResultSet selectDynamic(ModelPhone phone) throws SQLException;
    int insertPhone(ModelPhone phone) throws SQLException;
    int updatePhone(ModelPhone wherephone, ModelPhone setphone) throws SQLException;
    int deletePhone(ModelPhone phone) throws SQLException;
}
