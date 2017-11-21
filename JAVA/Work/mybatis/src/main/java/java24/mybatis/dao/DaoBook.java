package java24.mybatis.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java24.mybatis.inf.IBook;
import java24.mybatis.model.ModelBook;

@Repository("daobook")
public class DaoBook implements IBook {
    
    @Autowired
    @Qualifier("sqlSession")
    private SqlSession session;

    @Override
    public int getCount(ModelBook book) throws Exception {
        int result = -1;
        result = session.selectOne("mapper.mapperBook.getCount", book);
        return result;
    }

    @Override
    public int getMaxBookid() throws Exception {
        int result = -1;
        result = session.selectOne("mapper.mapperBook.getMaxBookid");
        return result;
    }

    @Override
    public List<ModelBook> selectAll(ModelBook book) throws Exception {
        List<ModelBook> result = null; 
        result = session.selectList("mapper.mapperBook.selectAll", book);
        return result;
    }

    @Override
    public List<ModelBook> selectLike(ModelBook book) throws Exception {
        List<ModelBook> result = null;
        result = session.selectList("mapper.mapperBook.selectLike", book);
        return result;
    }

    @Override
    public List<ModelBook> selectEqual(ModelBook book) throws Exception {
        List<ModelBook> result = null;
        result = session.selectList("mapper.mapperBook.selectEqual", book);
        return result;
    }

    @Override
    public int insertBook(ModelBook book) throws Exception {
        int result = -1;
        result = session.insert("mapper.mapperBook.insertBook", book);
        return result;
    }

    @Override
    public int insertMap(String bookname, Date dtm, int authid)
            throws Exception {
        int result = -1;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("bookname", bookname);
        map.put("dtm", dtm);
        map.put("authid", authid);
        result = session.insert("mapper.mapperBook.insertMap", map);
        return result;
    }

    @Override
    public int updateBook(ModelBook wherebook, ModelBook setbook)
            throws Exception {
        int result = -1;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("wherebook", wherebook);
        map.put("setbook", setbook);
        result = session.update("mapper.mapperBook.updateMap", map);
        return result;
    }

    @Override
    public int deleteBook(ModelBook book) throws Exception {
        int result = -1;
        result = session.delete("mapper.mapperBook.deleteBook", book);
        return result;
    }

    @Override
    public List<ModelBook> selectDynamic(ModelBook book) throws Exception {
        List<ModelBook> result = null;
        result = session.selectList("mapper.mapperBook.selectDynamic", book);
        return result;
    }
    
}
