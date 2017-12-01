package board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import board.inf.IBoard;
import board.model.ModelArticle;
import board.model.ModelAttachFile;
import board.model.ModelBoard;
import board.model.ModelComments;

@Repository("daoboard")
public class DaoBoard implements IBoard {
    
    @Autowired
    @Qualifier("sqlSession")
    private SqlSession session;
    
    @Override
    public String getBoardName(String boardcd) throws Exception {
        String result = null;
        result = session.selectOne("mapper.mapperBoard.getBoardName", boardcd);
        return result;
    }
    
    @Override
    public ModelBoard getBoardOne(String boardcd) throws Exception {
        ModelBoard result = null;
        result = session.selectOne("mapper.mapperBoard.getBoardOne", boardcd);
        return result;
    }
    
    @Override
    public List<ModelBoard> getBoardList() throws Exception {
        List<ModelBoard> result = null;
        result = session.selectList("mapper.mapperBoard.getBoardList");
        return result;
    }
    
    @Override
    public int insertBoard(ModelBoard board) throws Exception {
        int result = -1;
        result = session.insert("mapper.mapperBoard.insertBoard", board);
        return result;
    }
    
    @Override
    public int updateBoard(ModelBoard whereValue, ModelBoard setValue) throws Exception {
        int result = -1;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("whereValue", whereValue);
        map.put("setValue", setValue);
        result = session.update("mapper.mapperBoard.updateBoard", map);
        return result;
    }
    
    @Override
    public int deleteBoard(ModelBoard board) throws Exception {
        int result = -1;
        result = session.insert("mapper.mapperBoard.deleteBoard", board);
        return result;
    }
    
    @Override
    public List<ModelBoard> getBoardSearch(ModelBoard board) throws Exception {
        List<ModelBoard> result = null;
        result = session.selectList("mapper.mapperBoard.getBoardSearch", board);
        return result;
    }
    
    @Override
    public int getBoardTotalRecord(String boardcd, String searchWord) throws Exception {
        int result = -1;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("boardcd", boardcd);
        map.put("searchWord", searchWord);
        result = session.selectOne("mapper.mapperBoard.getBoardTotalRecord", map);
        return result;
    }
    
    @Override
    public List<ModelBoard> getBoardPaging(String boardcd, String searchWord,
            Integer start, Integer end) throws Exception {
        List<ModelBoard> result = null;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("boardcd", boardcd);
        map.put("searchWord", searchWord);
        map.put("start", start);
        map.put("end", end);
        result = session.selectList("mapper.mapperBoard.getBoardPaging", map);
        return result;
    }
    
    @Override
    public int insertBoardList(List<ModelBoard> item) throws Exception {
        int result = -1;
        result = session.insert("mapper.mapperBoard.insertBoardList", item);
        return result;
    }
    
    @Override
    public int getArticleTotalRecord(String boardcd, String searchWord) throws Exception {
        int result = -1;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("boardcd", boardcd);
        map.put("searchWord", searchWord);
        result = session.selectOne("mapper.mapperBoard.getArticleTotalRecord", map);
        return result;
    }
    
    @Override
    public List<ModelArticle> getArticleList(String boardcd, String searchWord,
            Integer start, Integer end) throws Exception {
        List<ModelArticle> result = null;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("boardcd", boardcd);
        map.put("searchWord", searchWord);
        map.put("start", start);
        map.put("end", end);
        result = session.selectList("mapper.mapperBoard.getArticleList", map);
        return result;
    }
    
    @Override
    public List<ModelArticle> getArticle(Integer articleno) throws Exception {
        List<ModelArticle> result = null;
        result = session.selectList("mapper.mapperBoard.getArticle", articleno);
        return result;
    }
    
    @Override
    public int insertArticle(ModelArticle article) throws Exception {
//        int result = -1;
//        result = 
        session.insert("mapper.mapperBoard.insertArticle", article);
        return article.getArticleno();
    }
    
    @Override
    public int updateArticle(ModelArticle whereValue, ModelArticle setValue) throws Exception {
        int result = -1;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("whereValue", whereValue);
        map.put("setValue", setValue);
        result = session.update("mapper.mapperBoard.updateArticle", map);
        return result;
    }
    
    @Override
    public int deleteArticle(ModelArticle article) throws Exception {
        int result = -1;
        result = session.delete("mapper.mapperBoard.deleteArticle", article);
        return result;
    }
    
    @Override
    public int increaseHit(Integer articleno) throws Exception {
        int result = -1;
        result = session.update("mapper.mapperBoard.increaseHit", articleno);
        return result;
    }
    
    @Override
    public List<ModelArticle> getNextArticle(String boardcd, Integer articleno,
            String searchWord) throws Exception {
        List<ModelArticle> result = null;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("boardcd", boardcd);
        map.put("articleno", articleno);
        map.put("searchWord", searchWord);
        result = session.selectList("mapper.mapperBoard.getNextArticle", map);
        return result;
    }
    
    @Override
    public List<ModelArticle> getPrevArticle(String boardcd, Integer articleno,
            String searchWord) throws Exception {
        List<ModelArticle> result = null;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("boardcd", boardcd);
        map.put("articleno", articleno);
        map.put("searchWord", searchWord);
        result = session.selectList("mapper.mapperBoard.getPrevArticle", map);
        return result;
    }
    
    @Override
    public List<ModelAttachFile> getAttachFile(Integer attachfileno) throws Exception {
        List<ModelAttachFile> result = null;
        result = session.selectList("mapper.mapperBoard.getAttachFile", attachfileno);
        return result;
    }
    
    @Override
    public List<ModelAttachFile> getAttachFileList(Integer articleno) throws Exception {
        List<ModelAttachFile> result = null;
        result = session.selectList("mapper.mapperBoard.getAttachFileList", articleno);
        return result;
    }
    
    @Override
    public int insertAttachFile(ModelAttachFile attachfile) throws Exception {
        int result = -1;
        result = session.insert("mapper.mapperBoard.insertAttachFile", attachfile);
        return result;
    }
    
    @Override
    public int deleteAttachFile(ModelAttachFile attachfile) throws Exception {
        int result = -1;
        result = session.delete("mapper.mapperBoard.deleteAttachFile", attachfile);
        return result;
    }
    
    @Override
    public List<ModelComments> getComment(Integer commentno) throws Exception {
        List<ModelComments> result = null;
        result = session.selectList("mapper.mapperBoard.getComment", commentno);
        return result;
    }
    
    @Override
    public List<ModelComments> getCommentList(Integer articleno) throws Exception {
        List<ModelComments> result = null;
        result = session.selectList("mapper.mapperBoard.getCommentList", articleno);
        return result;
    }
    
    @Override
    public int insertComment(ModelComments comments) throws Exception {
        int result = -1;
        result = session.insert("mapper.mapperBoard.insertComment", comments);
        return result;
    }
    
    @Override
    public int updateComment(ModelComments whereValue, ModelComments setValue) throws Exception {
        int result = -1;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("whereValue", whereValue);
        map.put("setValue", setValue);
        result = session.update("mapper.mapperBoard.updateComment", map);
        return result;
    }
    
    @Override
    public int deleteComment(ModelComments comments) throws Exception {
        int result = -1;
        result = session.delete("mapper.mapperBoard.deleteComment", comments);
        return result;
    }
    
}
