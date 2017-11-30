package board.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import board.inf.IBoard;
import board.inf.IServiceBoard;
import board.model.ModelArticle;
import board.model.ModelAttachFile;
import board.model.ModelBoard;
import board.model.ModelComments;

@Service("serviceboard")
public class ServiceBoard implements IServiceBoard {
    
    private static Logger logger = LoggerFactory.getLogger(ServiceBoard.class); 
    
    @Autowired
    @Qualifier("daoboard")
    private IBoard dao;
    
    @Override
    public String getBoardName(String boardcd) throws Exception {
        String result = null;
        try {
            result = dao.getBoardName(boardcd);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error( "getBoardName " + e.getMessage() );
        }
        return result;
    }
    
    @Override
    public List<ModelBoard> getBoardOne(String boardcd) throws Exception {
        List<ModelBoard> result = null;
        try {
            result = dao.getBoardOne(boardcd);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error( "getBoardName " + e.getMessage() );
        }
        return result;
    }
    
    @Override
    public List<ModelBoard> getBoardList() throws Exception {
        List<ModelBoard> result = null;
        try {
            result = dao.getBoardList();
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error( "getBoardList " + e.getMessage() );
        }
        return result;
    }
    
    @Override
    public int insertBoard(ModelBoard board) throws Exception {
        int result = -1;
        try {
            result = dao.insertBoard(board);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error( "insertBoard " + e.getMessage() );
        }
        return result;
    }
    
    @Override
    public int updateBoard(ModelBoard whereValue, ModelBoard setValue) throws Exception {
        int result = -1;
        try {
            result = dao.updateBoard(whereValue, setValue);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error( "updateBoard " + e.getMessage() );
        }
        return result;
    }
    
    @Override
    public int deleteBoard(ModelBoard board) throws Exception {
        int result = -1;
        try {
            result = dao.deleteBoard(board);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error( "deleteBoard " + e.getMessage() );
        }
        return result;
    }
    
    @Override
    public List<ModelBoard> getBoardSearch(ModelBoard board) throws Exception {
        List<ModelBoard> result = null;
        try {
            result = dao.getBoardSearch(board);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error( "getBoardSearch " + e.getMessage() );
        }
        return result;
    }
    
    @Override
    public int getBoardTotalRecord(String boardcd, String searchWord) throws Exception {
        int result = -1;
        try {
            result = dao.getBoardTotalRecord(boardcd, searchWord);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error( "getBoardTotalRecord " + e.getMessage() );
        }
        return result;
    }
    
    @Override
    public List<ModelBoard> getBoardPaging(String boardcd, String searchWord,
            Integer start, Integer end) throws Exception {
        List<ModelBoard> result = null;
        try {
            result = dao.getBoardPaging(boardcd, searchWord, start, end);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error( "getBoardPaging " + e.getMessage() );
        }
        return result;
    }
    
    @Override
    public int insertBoardList(List<ModelBoard> item) throws Exception {
        int result = -1;
        try {
            result = dao.insertBoardList(item);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error( "insertBoardList " + e.getMessage() );
        }
        return result;
    }
    
    @Override
    public int getArticleTotalRecord(String boardcd, String searchWord) throws Exception {
        int result = -1;
        try {
            result = dao.getArticleTotalRecord(boardcd, searchWord);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error( "getArticleTotalRecord " + e.getMessage() );
        }
        return result;
    }
    
    @Override
    public List<ModelArticle> getArticleList(String boardcd, String searchWord,
            Integer start, Integer end) throws Exception {
        List<ModelArticle> result = null;
        try {
            result = dao.getArticleList(boardcd, searchWord, start, end);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error( "getArticleList " + e.getMessage() );
        }
        return result;
    }
    
    @Override
    public List<ModelArticle> getArticle(Integer articleno) throws Exception {
        List<ModelArticle> result = null;
        try {
            dao.increaseHit(articleno);
            result = dao.getArticle(articleno);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error( "getArticle " + e.getMessage() );
        }
        return result;
    }
    
    @Override
    public int insertArticle(ModelArticle article) throws Exception {
        int result = -1;
        try {
            result = dao.insertArticle(article);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error( "insertArticle " + e.getMessage() );
        }
        return result;
    }
    
    @Override
    public int updateArticle(ModelArticle whereValue, ModelArticle setValue) throws Exception {
        int result = -1;
        try {
            result = dao.updateArticle(whereValue, setValue);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error( "updateArticle " + e.getMessage() );
        }
        return result;
    }
    
    @Override
    public int deleteArticle(ModelArticle article) throws Exception {
        int result = -1;
        try {
            result = dao.deleteArticle(article);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error( "deleteArticle " + e.getMessage() );
        }
        return result;
    }
    
    @Override
    public int increaseHit(Integer articleno) throws Exception {
        int result = -1;
        try {
            result = dao.increaseHit(articleno);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error( "increaseHit " + e.getMessage() );
        }
        return result;
    }
    
    @Override
    public List<ModelArticle> getNextArticle(String boardcd, Integer articleno,
            String searchWord) throws Exception {
        List<ModelArticle> result = null;
        try {
            result = dao.getNextArticle(boardcd, articleno, searchWord);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error( "getNextArticle " + e.getMessage() );
        }
        return result;
    }
    
    @Override
    public List<ModelArticle> getPrevArticle(String boardcd, Integer articleno,
            String searchWord) throws Exception {
        List<ModelArticle> result = null;
        try {
            result = dao.getPrevArticle(boardcd, articleno, searchWord);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error( "getPrevArticle " + e.getMessage() );
        }
        return result;
    }
    
    @Override
    public List<ModelAttachFile> getAttachFile(Integer attachfileno) throws Exception {
        List<ModelAttachFile> result = null;
        try {
            result = dao.getAttachFile(attachfileno);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error( "getAttachFile " + e.getMessage() );
        }
        return result;
    }
    
    @Override
    public List<ModelAttachFile> getAttachFileList(Integer articleno) throws Exception {
        List<ModelAttachFile> result = null;
        try {
            result = dao.getAttachFileList(articleno);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error( "getAttachFileList " + e.getMessage() );
        }
        return result;
    }
    
    @Override
    public int insertAttachFile(ModelAttachFile attachfile) {
        int result = -1;
        try {
            result = dao.insertAttachFile(attachfile);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error( "insertAttachFile " + e.getMessage() );
        }
        return result;
    }
    
    @Override
    public int deleteAttachFile(ModelAttachFile attachfile) throws Exception {
        int result = -1;
        try {
            result = dao.deleteAttachFile(attachfile);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error( "deleteAttachFile " + e.getMessage() );
        }
        return result;
    }
    
    @Override
    public List<ModelComments> getComment(Integer commentno) throws Exception {
        List<ModelComments> result = null;
        try {
            result = dao.getComment(commentno);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error( "getComment " + e.getMessage() );
        }
        return result;
    }
    
    @Override
    public List<ModelComments> getCommentList(Integer articleno) throws Exception {
        List<ModelComments> result = null;
        try {
            result = dao.getCommentList(articleno);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error( "getCommentList " + e.getMessage() );
        }
        return result;
    }
    
    @Override
    public int insertComment(ModelComments comments) throws Exception {
        int result = -1;
        try {
            result = dao.insertComment(comments);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error( "insertComment " + e.getMessage() );
        }
        return result;
    }
    
    @Override
    public int updateComment(ModelComments whereValue, ModelComments setValue) throws Exception {
        int result = -1;
        try {
            result = dao.updateComment(whereValue, setValue);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error( "updateComment " + e.getMessage() );
        }
        return result;
    }
    
    @Override
    public int deleteComment(ModelComments comments) throws Exception {
        int result = -1;
        try {
            result = dao.deleteComment(comments);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error( "deleteComment " + e.getMessage() );
        }
        return result;
    }
    
}
