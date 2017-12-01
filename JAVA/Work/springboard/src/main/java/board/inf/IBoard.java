package board.inf;

import java.util.List;

import board.model.ModelArticle;
import board.model.ModelAttachFile;
import board.model.ModelBoard;
import board.model.ModelComments;

public interface IBoard {
    String getBoardName(String boardcd) throws Exception;
    ModelBoard getBoardOne(String boardcd) throws Exception;
    List<ModelBoard> getBoardList() throws Exception;
    int insertBoard(ModelBoard board) throws Exception;
    int updateBoard(ModelBoard whereValue, ModelBoard setValue) throws Exception;
    int deleteBoard(ModelBoard board) throws Exception;
    List<ModelBoard> getBoardSearch(ModelBoard board) throws Exception;
    int getBoardTotalRecord(String boardcd, String searchWord) throws Exception;
    List<ModelBoard> getBoardPaging(String boardcd, String searchWord, Integer start, Integer end) throws Exception;
    int insertBoardList(List<ModelBoard> item) throws Exception;
    
    int getArticleTotalRecord(String boardcd, String searchWord) throws Exception;
    List<ModelArticle> getArticleList(String boardcd, String searchWord, Integer start, Integer end) throws Exception;
    List<ModelArticle> getArticle(Integer articleno) throws Exception;
    int insertArticle(ModelArticle article) throws Exception;
    int updateArticle(ModelArticle whereValue, ModelArticle setValue) throws Exception;
    int deleteArticle(ModelArticle article) throws Exception;
    int increaseHit(Integer articleno) throws Exception;
    List<ModelArticle> getNextArticle(String boardcd, Integer articleno, String searchWord) throws Exception;
    List<ModelArticle> getPrevArticle(String boardcd, Integer articleno, String searchWord) throws Exception;
    
    List<ModelAttachFile> getAttachFile(Integer attachfileno) throws Exception;
    List<ModelAttachFile> getAttachFileList(Integer articleno) throws Exception;
    int insertAttachFile(ModelAttachFile attachfile) throws Exception;
    int deleteAttachFile(ModelAttachFile attachfile) throws Exception;
    
    List<ModelComments> getComment(Integer commentno) throws Exception;
    List<ModelComments> getCommentList(Integer articleno) throws Exception;
    int insertComment(ModelComments comments) throws Exception;
    int updateComment(ModelComments whereValue, ModelComments setValue) throws Exception;
    int deleteComment(ModelComments comments) throws Exception;
}