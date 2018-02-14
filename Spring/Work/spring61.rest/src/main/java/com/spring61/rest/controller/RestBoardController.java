package com.spring61.rest.controller;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.google.gson.Gson;
import com.spring61.rest.inf.*;
import com.spring61.rest.model.*;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/rest")
public class RestBoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(RestBoardController.class);
	
	// ServiceUser 인스턴스 만들기.
	@Autowired 
	private IServiceUser usersvr;

    // ServiceBoard 인스턴스 만들기.
    @Autowired
    private IServiceBoard boardsvr;

    private Gson gson = new Gson();

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public ModelUser login(String userid, String passwd) {
        logger.info("/rest/login");        
        return usersvr.login( userid, passwd );
    } 
    
    @RequestMapping(value = "/logout", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public int logout(String userid) {
        logger.info("/rest/logout");        
        return usersvr.logout( userid );
    } 
    
    @RequestMapping(value = "/checkuserid", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public int checkuserid(String userid) {
        logger.info("/rest/checkuserid");        
        return usersvr.checkuserid( userid );
    } 
    
    @RequestMapping(value = "/checkpassword", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public int checkpassword(String userid, String passwd) {
        logger.info("/rest/checkpassword");        
        return usersvr.checkpassword( userid, passwd );
    } 
    
    @RequestMapping(value = "/selectuserone", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public ModelUser selectuserone(@RequestBody ModelUser user) {
        logger.info("/rest/selectuserone");
        return usersvr.selectUserOne( user );
    } 
    
    @RequestMapping(value = "/selectuserlist", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public List<ModelUser> selectuserlist(@RequestBody ModelUser user) {
        logger.info("/rest/selectuserlist");
        return usersvr.selectUserList( user );
    } 

    @RequestMapping(value = "/insertuser", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public int insertuser( @RequestBody ModelUser user) {
        logger.info("/rest/insertuser");        
        return usersvr.insertUser( user );
    } 
    
    @RequestMapping(value = "/updatepasswd", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public int updatepasswd(String userid, String currentPasswd, String newPasswd) {
        logger.info("/rest/updatepasswd");        
        return usersvr.updatePasswd( userid,currentPasswd, newPasswd );
    } 
    
    @RequestMapping(value = "/updateuserinfo", method = {RequestMethod.POST} )
    @ResponseBody
    public int updateuserinfo( @RequestBody Map<String, Object> maps) {
        logger.info("/rest/updateuserinfo");        

        //JSONObject(json string) ---> ModelUser객체(java object)
        Gson gson = new Gson();
        ModelUser setValue   = gson.fromJson(maps.get("setValue").toString()  , ModelUser.class);
        ModelUser whereValue = gson.fromJson(maps.get("whereValue").toString(), ModelUser.class);
                
        return usersvr.updateUserInfo( setValue, whereValue );
    } 
    
    @RequestMapping(value = "/updateretire", method = {RequestMethod.POST} )
    @ResponseBody
    public int updateretire( @RequestBody ModelUser user) {
        logger.info("/rest/updateretire");        
        return usersvr.updateRetire( user );
    } 

    /**
     * 클라이언트 변수명: cd
     * 서버       변수명: boardcd
     */
    @RequestMapping(value = "/getboardone", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public ModelBoard getboardone( @RequestParam("cd") String boardcd) {
        logger.info("/rest/getboardone");        
        return boardsvr.getBoardOne( boardcd );
    } 
    
    @RequestMapping(value = "/getboardname", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public String getboardname( String boardcd) {
        logger.info("/rest/getboardname");        
        return boardsvr.getBoardName( boardcd );
    } 

    
    @RequestMapping(value = "/getboardtotalrecord", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public int getboardtotalrecord( String searchWord) {
        logger.info("/rest/getboardtotalrecord");        
        return boardsvr.getBoardTotalRecord( searchWord );
    } 

    @RequestMapping(value = "/getboardpaging", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public List<ModelBoard> getBoardPaging(   String searchWord
                                            , @RequestParam(defaultValue="0" )  int start
                                            , @RequestParam(defaultValue="10")  int end  ) {
        logger.info("/rest/getBoardPaging");        
        return boardsvr.getBoardPaging( searchWord, start, end  );
    } 

    @RequestMapping(value = "/getboardlist", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public List<ModelBoard> getBoardList( String searchWord  ) {
        logger.info("/rest/getBoardList");        
        return boardsvr.getBoardList( searchWord  );
    } 

    @RequestMapping(value = "/insertboard", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public int insertBoard( @RequestBody ModelBoard board ) {
        logger.info("/rest/insertBoard");        
        return boardsvr.insertBoard( board  );
    } 

    @RequestMapping(value = "/updateboard", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public int updateBoard( @RequestBody ModelBoard setValue, @RequestBody ModelBoard whereValue ) {
        logger.info("/rest/updateBoard");        
        return boardsvr.updateBoard( setValue, whereValue );
    }  

    @RequestMapping(value = "/deleteboard", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public int deleteBoard( @RequestBody ModelBoard board) {
        logger.info("/rest/deleteBoard");        
        return boardsvr.deleteBoard( board );
    } 

    @RequestMapping(value = "/insertboardlist", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public int insertBoardList( @RequestBody List<ModelBoard> list) {
        logger.info("/rest/insertBoardList");        
        return boardsvr.insertBoardList( list );
    } 

    @RequestMapping(value = "/getarticletotalrecord", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public int getArticleTotalRecord( String boardcd, String searchWord) {
        logger.info("/rest/getArticleTotalRecord");        
        return boardsvr.getArticleTotalRecord( boardcd, searchWord );
    } 
    @RequestMapping(value = "/getarticlelist", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public String getArticleList( String boardcd
            , String searchWord
            , @RequestParam(defaultValue="0") int start
            , @RequestParam(defaultValue="10") int end ) {
        logger.info("/rest/getArticleList");    
        
        List<ModelArticle> list = boardsvr.getArticleList( boardcd, searchWord,start, end );
        String result = gson.toJson(list);
        
        return result;
    } 

    @RequestMapping(value = "/getarticle", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public String getArticle( @RequestParam(defaultValue="0") int articleno ) {
        logger.info("/rest/getArticle");        
        ModelArticle article = boardsvr.getArticle( articleno );
        String result = gson.toJson(article);
        return result;
    }

    @RequestMapping(value = "/insertarticle", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public int insertArticle( @RequestBody ModelArticle article) {
        logger.info("/rest/insertArticle");            
        return boardsvr.insertArticle( article );
    }

    @RequestMapping(value = "/updatearticle", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public int updateArticle( @RequestBody ModelArticle setValue, ModelArticle whereValue) {
        logger.info("/rest/updateArticle");            
        return boardsvr.updateArticle( setValue, whereValue );
    }

    @RequestMapping(value = "/deletearticle", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public int deleteArticle( @RequestBody ModelArticle article) {
        logger.info("/rest/deleteArticle");            
        return boardsvr.deleteArticle( article);
    }

    @RequestMapping(value = "/increasehit", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public int increaseHit( @RequestParam(defaultValue="0") int articleno ) {
        logger.info("/rest/increaseHit");            
        return boardsvr.increaseHit( articleno );
    }

    @RequestMapping(value = "/getnextarticle", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public ModelArticle getNextArticle( @RequestParam(defaultValue="0") int articleno
            , String boardcd
            , String searchWord ) {
        logger.info("/rest/getNextArticle");            
        return boardsvr.getNextArticle( articleno, boardcd, searchWord );
    }

    @RequestMapping(value = "/getprevarticle", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public ModelArticle getPrevArticle( @RequestParam(defaultValue="0") int articleno
            , String boardcd
            , String searchWord ) {
        logger.info("/rest/getPrevArticle");            
        return boardsvr.getPrevArticle( articleno, boardcd, searchWord );
    }

    @RequestMapping(value = "/getcomment", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public String getComment( @RequestParam(defaultValue="0") int commentNo) {
        logger.info("/rest/getComment");   
        ModelComments comment = boardsvr.getComment( commentNo );
        String result = gson.toJson( comment );
        return result;
    }

    @RequestMapping(value = "/getcommentlist", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public String getCommentList( @RequestParam(defaultValue="0") int articleno) {
        logger.info("/rest/getCommentList");   

        List<ModelComments> comments = boardsvr.getCommentList( articleno ); 
        String result = gson.toJson( comments );
        return result;
    }

    @RequestMapping(value = "/insertcomment", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public int insertComment( @RequestBody ModelComments comment) {
        logger.info("/rest/insertComment");            
        return boardsvr.insertComment( comment );
    }

    @RequestMapping(value = "/updatecomment", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public int updateComment( @RequestBody ModelComments setValue
                            , @RequestBody ModelComments whereValue) {
        logger.info("/rest/updateComment");            
        return boardsvr.updateComment( setValue, whereValue );
    }

    @RequestMapping(value = "/deletecomment", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public int deleteComment( @RequestBody ModelComments comment) {
        logger.info("/rest/deleteComment");            
        return boardsvr.deleteComment( comment );
    }

    @RequestMapping(value = "/getattachfile", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public ModelAttachFile getAttachFile( @RequestParam(defaultValue="0") int attachFileNo) {
        logger.info("/rest/getAttachFile");            
        return boardsvr.getAttachFile( attachFileNo );
    }

    @RequestMapping(value = "/getattachfilelist", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public List<ModelAttachFile> getAttachFileList( @RequestParam(defaultValue="0") int articleno) {
        logger.info("/rest/getAttachFileList");            
        return boardsvr.getAttachFileList( articleno );
    }

    @RequestMapping(value = "/insertattachfile", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public int insertAttachFile( @RequestBody ModelAttachFile attachFile) {
        logger.info("/rest/insertAttachFile");            
        return boardsvr.insertAttachFile( attachFile );
    }

    @RequestMapping(value = "/deleteattachfile", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public int deleteAttachFile( @RequestBody ModelAttachFile attachFile) {
        logger.info("/rest/deleteAttachFile");            
        return boardsvr.deleteAttachFile( attachFile );
    }
}
