package com.spring61.rest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.spring61.rest.inf.*;
import com.spring61.rest.model.*;

import java.util.*;

@Service("serviceboard")
public class ServiceBoard implements IServiceBoard {
    // SLF4J Logging
    private static Logger logger = LoggerFactory.getLogger(ServiceBoard.class);
    
    @Autowired
    @Qualifier("daoboard")
    private IBoard daoboard;
    
    public ServiceBoard() {
        super();
    }

    @Override
    public String getBoardName(String boardcd) {
        
        String result = null;
        try {
            result = daoboard.getBoardName(boardcd);
        } catch (Exception e) {
            logger.error("getBoardName " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public ModelBoard getBoardOne(String boardcd) {
        ModelBoard result = null;
        try {
            result = daoboard.getBoardOne(boardcd);
        } catch (Exception e) {
            logger.error("getBoardOne " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int getBoardTotalRecord(String searchWord) {
        int result = -1;
        try {
            result = daoboard.getBoardTotalRecord(searchWord);
        } catch (Exception e) {
            logger.error("getBoardTotalRecord " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public List<ModelBoard> getBoardList(String searchWord) {
        List<ModelBoard> result = null;
        try {
            result = daoboard.getBoardList(searchWord);
        } catch (Exception e) {
            logger.error("getBoardList " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int insertBoard(ModelBoard board) {
        
        int result = -1;
        try {
            result = daoboard.insertBoard(board);
        } catch (Exception e) {
            logger.error("insertBoard " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int updateBoard(ModelBoard setValue, ModelBoard whereValue) {
        
        int result = -1;
        try {
            result = daoboard.updateBoard(setValue, whereValue);
        } catch (Exception e) {
            logger.error("updateBoard" + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int deleteBoard(ModelBoard board) {
        int result = -1;
        try {
            result = daoboard.deleteBoard(board);
        } catch (Exception e) {
            logger.error("deleteBoard" + e.getMessage());
        }
        
        return result;
    }

    @Override
    public List<ModelBoard> getBoardPaging(String searchWord, int start, int end) {
        
        List<ModelBoard> result = null;
        try {
            result = daoboard.getBoardPaging(searchWord, start, end);
        } catch (Exception e) {
            logger.error("getBoardPaging  " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int insertBoardList(List<ModelBoard> list) {
        int result = -1;
        try {
            result = daoboard.insertBoardList(list);
            //session.commit();
        } catch (Exception e) {
            logger.error("insertBoardList" + e.getMessage() );
            //session.rollback();
        }
        
        return result;
    }

    @Override
    public int getArticleTotalRecord(String boardcd, String searchWord) {
        int result = 0;
        try {
            result = daoboard.getArticleTotalRecord(boardcd, searchWord);
        } catch (Exception e) {
            logger.error("getArticleTotalRecord  " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public List<ModelArticle> getArticleList(String boardcd, String searchWord, int start, int end) {
        
        List<ModelArticle> result = null;
        try {
            result = daoboard.getArticleList(boardcd, searchWord, start, end);
        } catch (Exception e) {
            logger.error("getArticleList  " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public ModelArticle getArticle(int articleno) {
      
        ModelArticle result = null;
        try {
            // 상세보기를 할때마다 페이지 조회수를 1 증가 시키도록 하려면
            // 이를 위해서는 transArticle() 메서드를 사용하시오.
            result = daoboard.getArticle ( articleno );
        } catch (Exception e) {
            logger.error("getArticle  " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int insertArticle(ModelArticle article) {
        int result = -1;
        try {
            result = daoboard.insertArticle(article);
        } catch (Exception e) {
            logger.error("insertArticle " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int updateArticle(ModelArticle setValue, ModelArticle whereValue) {
        
        int result = -1;
        try {
            result = daoboard.updateArticle(setValue, whereValue);
        } catch (Exception e) {
            logger.error("updateArticle " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int deleteArticle(ModelArticle article) {
        int result = -1;
        try {
            result = daoboard.deleteArticle(article);
        } catch (Exception e) {
            logger.error("deleteArticle  " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int increaseHit(int articleno) {
        int result = -1;
        try {
            result = daoboard.increaseHit(articleno);
        } catch (Exception e) {
            logger.error("increaseHit  " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public ModelArticle getNextArticle(int articleno, String boardcd, String searchWord) {
        
        ModelArticle result = null;
        try {
            result = daoboard.getNextArticle( articleno, boardcd, searchWord  );
        } catch (Exception e) {
            logger.error("getNextArticle  " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public ModelArticle getPrevArticle(int articleno, String boardcd, String searchWord) {
        ModelArticle result = null;
        try {
            result = daoboard.getPrevArticle( articleno, boardcd, searchWord );
        } catch (Exception e) {
            logger.error("getPrevArticle  " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public ModelAttachFile getAttachFile(int attachFileNo) {
        ModelAttachFile result = null;
        try {
            result = daoboard.getAttachFile( attachFileNo );
        } catch (Exception e) {
            logger.error("getAttachFile  " + e.getMessage() );
        }
        
        return result;
    }
    
    @Override
    public List<ModelAttachFile> getAttachFileList(int articleno) {
        List<ModelAttachFile> result = null;
        try {
            result = daoboard.getAttachFileList( articleno );
        } catch (Exception e) {
            logger.error("getAttachFileList  " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int insertAttachFile(ModelAttachFile attachFile) {
        int result = -1;
        try {
            result = daoboard.insertAttachFile(attachFile);
        } catch (Exception e) {
            logger.error("insertAttachFile " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int deleteAttachFile(ModelAttachFile attachFile) {
        int result = -1;
        try {
            result = daoboard.deleteAttachFile(attachFile);
        } catch (Exception e) {
            logger.error("deleteAttachFile " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public ModelComments getComment(int commentNo) {
        ModelComments result = null;
        try {
            result = daoboard.getComment( commentNo );
        } catch (Exception e) {
            logger.error("getComment  " + e.getMessage() );
        }
        
        return result;
    }


    @Override
    public List<ModelComments> getCommentList(int articleno) {
        List<ModelComments>  result = null;
        try {
            result = daoboard.getCommentList( articleno );
        } catch (Exception e) {
            logger.error("getCommentList  " + e.getMessage() );
        }
        
        return result;
    }
    
    @Override
    public int insertComment(ModelComments comment) {
        int result = -1;
        try {
            result = daoboard.insertComment(comment);
        } catch (Exception e) {
            logger.error("insertComment " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int updateComment(ModelComments setValue, ModelComments whereValue) {
        int result = -1;
        try {
            result = daoboard.updateComment( setValue, whereValue );
        } catch (Exception e) {
            logger.error("updateComment " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int deleteComment(ModelComments comment) {
        int result = -1;
        try {
            result = daoboard.deleteComment( comment );
        } catch (Exception e) {
            logger.error("deleteComment " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public ModelArticle transArticle(int articleno) {

        ModelArticle result = null;
        try {
            // 상세보기를 할때마다 페이지 조회수를 1 증가 시키기 위해서.
            // 하단에 목록에서 조회수를 제대로 보기위해서는
            // 목록 레코드를 페치하기 전에 조회수를 먼저 증가시켜야 한다.
            // 사용자 IP 와 시간을 고려해서 조회수를 증가하도록...            
                     daoboard.increaseHit( articleno );
            result = daoboard.getArticle ( articleno );
        } catch (Exception e) {
            logger.error("transArticle  " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int transDeleteArticle(int articleno) {

        int result = -1;
        
        // transcation을 이용하여 삭제를 묶는다.
        // tb_bbs_attachfile, tb_bbs_comment, tb_bbs_article        
        try {
            ModelAttachFile attachFile= new ModelAttachFile();
            attachFile.setArticleno(articleno);
            daoboard.deleteAttachFile( attachFile );
            
            daoboard.deleteComment(new ModelComments( articleno) );
            daoboard.deleteArticle(new ModelArticle( articleno ) );
            result = 1;
        } catch (Exception e) {
            logger.error("transDeleteArticle" + e.getMessage() );
        }
        
        return result;
    }
}
