package board.inf;

import java.util.List;

import board.model.ModelArticle;
import board.model.ModelAttachFile;
import board.model.ModelBoard;
import board.model.ModelComments;

public interface IBoard {
    String getBoardName(String boardcd) throws Exception;
    List<ModelBoard> getBoardOne(String boardcd) throws Exception;
    List<ModelBoard> getBoardList() throws Exception;
    int insertBoard(ModelBoard board) throws Exception;
    int updateBoard(ModelBoard searchValue, ModelBoard updateValue) throws Exception;
    int deleteBoard(ModelBoard board) throws Exception;
    List<ModelBoard> getBoardSearch(ModelBoard board) throws Exception;
    int getBoardTotalRecord(String boardcd, String searchWord) throws Exception;
    List<ModelBoard> getBoardPaging(String boardcd, String SearchWord, Integer start, Integer end) throws Exception;
    int insertBoardList(String boardcd, String boardnm, Boolean UseYN); //asdasdasd

    int getArticleTotalRecord(String boardcd, String searchWord);
    List<ModelArticle> getArticleList(String boardcd, String searchWord, Integer start, Integer end);
    List<ModelArticle> getArticle(Integer articleno);
    int insertArticle(ModelArticle article);
    int updateArticle(ModelArticle searchValue, ModelArticle updateValue);
    int deleteArticle(ModelArticle article);
    int increaseHit(Integer articleno);
    List<ModelArticle> getNextArticle(String boardcd, Integer articleno, String searchWord);
    List<ModelArticle> getPrevArticle(String boardcd, Integer articleno, String searchWord);

    List<ModelAttachFile> getAttachFile(Integer attachFileNo);
    List<ModelAttachFile> getAttachFileList(Integer articleno);
    int insertAttachFile(ModelAttachFile attachfile);
    int deleteAttachFile(ModelAttachFile attachfile);
    int insertComment(ModelComments comments);
    int updateComment(ModelComments searchValue, ModelComments updateValue);
    int deleteComment(ModelComments comments);
}
