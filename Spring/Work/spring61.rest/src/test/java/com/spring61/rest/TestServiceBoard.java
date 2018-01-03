package com.spring61.rest;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.sql.DataSource;

import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring61.rest.inf.IServiceBoard;
import com.spring61.rest.model.*;

import org.junit.runners.MethodSorters;

//Sorts by method name
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestServiceBoard {
    
    private static IServiceBoard service  = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml");
        service   = context.getBean("serviceboard", IServiceBoard.class); 
        
        // DB Table 초기화 코드
        javax.sql.DataSource dataSource = context.getBean("dataSource", javax.sql.DataSource.class);                 
        org.apache.ibatis.jdbc.ScriptRunner runner = new org.apache.ibatis.jdbc.ScriptRunner(dataSource.getConnection());
        runner.setAutoCommit(true);
        runner.setStopOnError(true);
        String sqlScriptFilePath = ClassLoader.getSystemClassLoader().getResource("java21/ddl/board.ddl.mysql.sql").getFile();
        java.io.Reader br = new java.io.BufferedReader(new java.io.FileReader( sqlScriptFilePath ));
        runner.runScript( br);
        runner.closeConnection();
    }
    
    @Test
    public void test01_getBoardName() {
        String result = service.getBoardName("free");
        assertEquals(result, "자유게시판");
    }

    @Test
    public void test02_getBoardOne() {      
        ModelBoard result = service.getBoardOne("free");
        assertEquals(result.getBoardnm(), "자유게시판");
        assertEquals(result.getBoardcd(), "free"      );
        assertEquals(result.getUseYN()  , true        );
    }

    @Test
    public void test03_getBoardList() {    

        String searchWord = "";
        List<ModelBoard> result = service.getBoardList(searchWord);        
        assertSame(70, result.size());
        
        searchWord ="자료실";
        result = service.getBoardList(searchWord);        
        assertSame(result.size(), 1);
    }

    @Test
    public void test05_getBoardTotalRecord() {
        String searchWord = "";
        int result = service.getBoardTotalRecord( searchWord );
        assertEquals(70, result);

        searchWord ="자료실";
        result = service.getBoardTotalRecord( searchWord );
        assertEquals(1, result);
    }

    @Test
    public void test06_getBoardPaging() {

        String boardcd    = "";
        String searchWord = "";
        int    start = 1;
        int    end   = 3;
        
        List<ModelBoard> result = service.getBoardPaging(boardcd, searchWord, start, end);
        assertEquals(result.size(), 3-1+1);        
    }

    @Test
    public void test11_insertBoard()  {
        ModelBoard model = new ModelBoard();
        model.setBoardcd("notice");
        model.setBoardnm("공지사항");
        model.setInsertDT(new Date());
        model.setInsertUID("insertUID");
        model.setUpdateDT(new Date());
        model.setUpdateUID("updateUID");
        model.setUseYN(true);
                       
        int result = service.insertBoard(model);
        assertEquals(result, 1);
    }

    @Test
    public void test12_insertBoardList() {
        ModelBoard model = null;
        List<ModelBoard> list = new ArrayList<ModelBoard>();
        Date d = new Date();
        String current = new SimpleDateFormat("yyMMddHHmmss").format( d );
        
        for( int i=0; i<10; i=i+1){            
            model = new ModelBoard();
            model.setBoardcd("notice" + current + i );
            model.setBoardnm("공지사항" + current + i );
            model.setUseYN(true);     
            model.setInsertDT( d );
            model.setInsertUID("insertUID" + i);
            model.setUpdateDT( d );
            model.setUpdateUID("updateUID" + i);  
            
            list.add( model );
        }
               
        int result = service.insertBoardList(list);
        assertEquals(result, list.size());
    }

    @Test
    public void test13_updateBoard() {
        ModelBoard setBoard = new ModelBoard();
        setBoard.setBoardcd("notice");
        setBoard.setBoardnm("새로운 공지사항");
        setBoard.setUpdateDT(new Date());
        setBoard.setUpdateUID("updateUID");
        setBoard.setUseYN(true);
        
        ModelBoard whereBoard = new ModelBoard();
        whereBoard.setBoardcd("notice");
               
        int result = service.updateBoard(setBoard, whereBoard);
        assertEquals(result, 1);
        

        setBoard.setBoardnm("");
        setBoard.setUpdateDT(null);
        setBoard.setUpdateUID("updateUID");
        setBoard.setUseYN(true);
        
        whereBoard = new ModelBoard();
        whereBoard.setBoardcd("notice");
               
        result = service.updateBoard(setBoard, whereBoard);
        assertEquals(result, 1);
    }

    @Test
    public void test14_deleteBoard() {
        ModelBoard model = new ModelBoard();
        model.setBoardcd("notice");
        model.setUseYN(true);
               
        int result = service.deleteBoard(model);
        assertEquals(result, 1);
    }

    @Test
    public void test21_getArticleTotalRecord() {
         
        String boardcd    = "free";  
        String searchWord = "article";        
        int result = service.getArticleTotalRecord(boardcd, searchWord);
        assertEquals(result, 201);

        boardcd    = "free";  
        searchWord = "";        
        result = service.getArticleTotalRecord(boardcd, searchWord);
        assertEquals(result, 201);
    }

    @Test
    public void test22_getArticleList() {
         
        String boardcd    = "free";  
        String searchWord = "article";
        int    start = 2;
        int    end   = 7;
        
        List<ModelArticle> result = service.getArticleList(boardcd, searchWord, start, end);
        assertEquals(6, result.size());
        
        boardcd    = "free";  
        searchWord = "10";
        start = 1;
        end   = 12;
        result = service.getArticleList(boardcd, searchWord, start, end);
        assertEquals(12, result.size());
    }

    @Test
    public void test23_getArticle() {
          
        ModelArticle result = service.getArticle(1);
        assertEquals(result.getTitle(), "article test  01");
    }

    @Test
    public void test24_insertArticle() {
        ModelArticle model = new ModelArticle();
        model.setBoardcd("free");
        model.setContent("tesr yd cyt");
        model.setEmail("sjydevil@gamil.com");
        model.setHit(0);
        model.setRegdate( new Date() );
        model.setTitle("insert article test");
        model.setUseYN(true);
        
        model.setInsertDT(new Date());
        model.setInsertUID("insertUID");
        model.setUpdateDT(new Date());
        model.setUpdateUID("updateUID");
                       
        int result = service.insertArticle(model);
        assertEquals(result, 1);
    }

    @Test
    public void test25_updateArticle() {       
        
        ModelArticle setValue = new ModelArticle(); 
        setValue.setContent("tesr update cyt");
        setValue.setTitle("update article test");
        setValue.setUseYN(true);
        setValue.setUpdateDT(new Date());
        setValue.setUpdateUID("updateUID");
        
        ModelArticle whereValue = new ModelArticle();     
        whereValue.setBoardcd("free");
        whereValue.setContent("tesr update cyt");
        whereValue.setEmail("sjydevil@gamil.com");
                       
        int result = service.updateArticle(setValue, whereValue);
        assertEquals(result, 1);
    }

    @Test
    public void test26_deleteArticle() {
        ModelArticle whereValue = new ModelArticle();     
        whereValue.setBoardcd("free");
        whereValue.setContent("tesr update cyt");
        whereValue.setEmail("sjydevil@gamil.com");
                       
        int result = service.deleteArticle(whereValue);
        assertEquals(result, 1);
    }

    @Test
    public void test27_increaseHit() {  
        int articleno  = 1;
        
        ModelArticle beforeArticle = service.getArticle(articleno);        
                                     service.increaseHit(articleno);        
        ModelArticle afterArticle  = service.getArticle(articleno);

        assertSame(beforeArticle.getHit()+2, afterArticle.getHit());
    }

    @Test
    public void test28_getNextArticle() {
        ModelArticle result = service.getNextArticle(186, "free", "test");
        assertTrue(187 == result.getArticleno() );
    }

    @Test
    public void test29_getPrevArticle() {
        ModelArticle result = service.getPrevArticle(186, "free", "test");
        assertTrue(185 == result.getArticleno() );
    }

    @Test
    public void test41_getAttachFile() {
        ModelAttachFile result = service.getAttachFile( 2 );
        assertSame(result.getArticleno(), 1);
    }

    @Test
    public void test42_getAttachFileList() {
        List<ModelAttachFile> result = service.getAttachFileList(1);
        assertSame(result.size(), 7);
    }
    @Test
    public void test43_insertAttachFile() {
        ModelAttachFile model = new ModelAttachFile();
        model.setArticleno(2);
        model.setFilename("insert Attach File test");
        model.setFilesize((long)2008);
        model.setFiletype("txt");
        model.setUseYN(true);        
        model.setInsertDT(new Date());
        model.setInsertUID("insertUID");
        model.setUpdateDT(new Date());
        model.setUpdateUID("updateUID");
                       
        int result = service.insertAttachFile(model);
        assertEquals(result, 1);
    }

    @Test
    public void test44_deleteAttachFile() {
        ModelAttachFile model = new ModelAttachFile();
        model.setAttachfileno(3);
        //model.setArticleno(1);
        model.setUseYN(true);        
                       
        int result = service.deleteAttachFile(model);
        assertEquals(result, 1);
    }

    @Test
    public void test61_getComment() {
        ModelComments result = service.getComment( 1 );
        assertSame(result.getArticleno(), 1);
    }

    @Test
    public void test62_getCommentList() {
        List<ModelComments> result = service.getCommentList( 1 );
        assertSame(result.size(), 1);
    }

    @Test
    public void test63_insertComment() {
        ModelComments model = new ModelComments();
        model.setArticleno(1); 
        //model.setCommentno(commentno);
        model.setEmail("sjydevil@gmail.com");
        model.setMemo("insert comment");
        model.setRegdate(new Date()); 
        model.setInsertDT(new Date());
        model.setInsertUID("insertUID");
        model.setUpdateDT(new Date());
        model.setUpdateUID("updateUID");
                       
        int result = service.insertComment(model);
        assertEquals(result, 1);
    }

    @Test
    public void test64_updateComment() {    
        
        ModelComments setValue = new ModelComments(); 
        setValue.setMemo("update Comment test");
        setValue.setRegdate( new Date() );
        setValue.setUseYN(true);
        setValue.setUpdateDT(new Date());
        setValue.setUpdateUID("updateUID");
        
        ModelComments whereValue = new ModelComments();     
        whereValue.setCommentno(1);
        whereValue.setArticleno(1);
        //whereValue.setEmail("sjydevil@gamil.com");        
               
        int result = service.updateComment(setValue, whereValue);
        assertEquals(result, 1);
    }

    @Test
    public void test65_deleteComment() {
        ModelComments whereValue = new ModelComments();     
        whereValue.setCommentno(2);
        whereValue.setArticleno(1);
        whereValue.setUseYN(true);
        whereValue.setEmail("sjydevil@gmail.com");
                       
        int result = service.deleteComment(whereValue);
        assertEquals(result, 1);
    }
}
