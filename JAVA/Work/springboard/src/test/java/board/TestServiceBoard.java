package board;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import board.model.ModelArticle;
import board.model.ModelBoard;
import board.service.ServiceBoard;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestServiceBoard {
    
    private static ServiceBoard service = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        ApplicationContext context = new
                ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        service = context.getBean("serviceboard", ServiceBoard.class);
        
        // DB Table 초기화 코드
//        javax.sql.DataSource dataSource = (javax.sql.DataSource)context.getBean("dataSource");
//        
//        org.apache.ibatis.jdbc.ScriptRunner runner = new
//        org.apache.ibatis.jdbc.ScriptRunner( dataSource.getConnection() );
//        runner.setAutoCommit(true);
//        runner.setStopOnError(true);
//        ClassLoader cl = ClassLoader.getSystemClassLoader();
//        String sf = cl.getResource("ddl/board.ddl.mysql.sql").getFile();
//        java.io.Reader br = new java.io.BufferedReader( new java.io.FileReader(sf) );
//        runner.runScript( br);
//        runner.closeConnection();
        
    }
    
    @Test
    public void testGetBoardName() throws Exception {
        String boardcd = "data";
        String rs = service.getBoardName(boardcd);
        assertEquals("자료실", rs);
    }
    
    @Test
    public void testGetBoardOne() throws Exception {
        String boardcd = "qna";
        List<ModelBoard> rs = service.getBoardOne(boardcd);
        String boardnm = rs.get(0).getBoardnm();
        int UseYN = rs.get(0).getUseYN();
        assertEquals("QnA게시판", boardnm);
        assertEquals(1, UseYN);
    }
    
    @Test
    public void testGetBoardList() throws Exception {
        List<ModelBoard> rs = service.getBoardList();
        String boardcd = rs.get(0).getBoardcd();
        String boardnm = rs.get(0).getBoardnm();
        int UseYN = rs.get(0).getUseYN();
        assertEquals("qna", boardcd);
        assertEquals("QnA게시판", boardnm);
        assertEquals(1, UseYN);
        boardcd = rs.get(1).getBoardcd();
        boardnm = rs.get(1).getBoardnm();
        UseYN = rs.get(1).getUseYN();
        assertEquals("data", boardcd);
        assertEquals("자료실", boardnm);
        assertEquals(1, UseYN);
        boardcd = rs.get(2).getBoardcd();
        boardnm = rs.get(2).getBoardnm();
        UseYN = rs.get(2).getUseYN();
        assertEquals("free", boardcd);
        assertEquals("자유게시판", boardnm);
        assertEquals(1, UseYN);
    }
    
    @Test
    public void testInsertBoard() throws Exception {
        ModelBoard board = new ModelBoard();
        board.setBoardcd("notify");
        board.setBoardnm("공자사항");
        board.setUseYN(1);
        int rs = service.insertBoard(board);
        assertTrue(rs >= 1);
    }
    
    @Test
    public void testUpdateBoard() throws Exception {
        ModelBoard whereValue = new ModelBoard();
        ModelBoard setValue = new ModelBoard();
        whereValue.setBoardcd("notify");
        whereValue.setBoardnm("공자사항");
        setValue.setBoardnm("공자사항");
        setValue.setUpdateUID(null);
        setValue.setUseYN(1);
        setValue.setUpdateDT(null);
        int rs = service.updateBoard(whereValue, setValue);
        assertTrue(rs >= 0);
    }
    
    @Test
    public void testDeleteBoard() throws Exception {
        ModelBoard board = new ModelBoard();
        board.setBoardcd("notify");
        int rs = service.deleteBoard(board);
        assertTrue(rs >= 0);
    }
    
    @Test
    public void testGetBoardSearch() throws Exception {
        ModelBoard board = new ModelBoard();
        board.setBoardcd("a");
        List<ModelBoard> rs = service.getBoardSearch(board);
        String boardcd = rs.get(0).getBoardcd();
        String boardnm = rs.get(0).getBoardnm();
        assertEquals("data", boardcd);
        assertEquals("자료실", boardnm);
        boardcd = rs.get(1).getBoardcd();
        boardnm = rs.get(1).getBoardnm();
        assertEquals("qna", boardcd);
        assertEquals("QnA게시판", boardnm);
    }
    
    @Test
    public void testGetBoardTotalRecord() throws Exception {
        fail("Not yet implemented");
    }
    
    @Test
    public void testGetBoardPaging() throws Exception {
        fail("Not yet implemented");
    }
    
    @Test
    public void testInsertBoardList() throws Exception {
        ModelBoard board = new ModelBoard();
        board.setBoardcd("notify");
        board.setBoardnm("공지사항");
        board.setUseYN(1);
        List<ModelBoard> item = new ArrayList<ModelBoard>();
        item.add(board);
        int rs = service.insertBoardList(item);
        assertTrue(rs >= 1);
    }
    
    @Test
    public void testGetArticleTotalRecord() throws Exception {
        String boardcd = "free";
        String searchWord = "test";
        int rs = service.getArticleTotalRecord(boardcd, searchWord);
        assertEquals(201, rs);
    }

    @Test
    public void testGetArticleList() throws Exception {
        String boardcd = "free";
        String searchWord = "test";
        Integer start = 192;
        Integer end = 201;
        List<ModelArticle> rs = service.getArticleList(boardcd, searchWord, start, end);
        String title = rs.get(0).getTitle();
        assertEquals("article test  10", title);
        title = rs.get(1).getTitle();
        assertEquals("article test  09", title);
        title = rs.get(2).getTitle();
        assertEquals("article test  08", title);
        title = rs.get(3).getTitle();
        assertEquals("article test  07", title);
    }
    
    @Test
    public void testGetArticle() throws Exception {
        Integer articleno = 2;
        List<ModelArticle> rs = service.getArticle(articleno);
        String boardcd = rs.get(0).getBoardcd();
        String title = rs.get(0).getTitle();
        String content = rs.get(0).getContent();
        String email = rs.get(0).getEmail();
        assertEquals("free", boardcd);
        assertEquals("article test  02", title);
        assertEquals("article test  02", content);
        assertEquals("aa@aa.co.kr", email);
    }
    
    @Test
    public void testInsertArticle() throws Exception {
        ModelArticle article = new ModelArticle();
        article.setBoardcd("data");
        article.setTitle("title test");
        article.setContent("content test");
        article.setEmail("test.aa.co.kr");
        article.setInsertUID(null);
        article.setUpdateUID(null);
        int rs = service.insertArticle(article);
        assertEquals(202, rs);
    }
    
    @Test
    public void testUpdateArticle() throws Exception {
        ModelArticle whereValue = new ModelArticle();
        ModelArticle setValue = new ModelArticle();
        whereValue.setArticleno(202);
        setValue.setTitle("test");
        setValue.setContent("test");
        setValue.setUseYN(1);
        setValue.setUpdateUID(null);
        setValue.setUpdateDT(null);
        int rs = service.updateArticle(whereValue, setValue);
        assertTrue(rs >= 0);
    }
    
    @Test
    public void testDeleteArticle() throws Exception {
        ModelArticle article = new ModelArticle();
        article.setArticleno(202);
        int rs = service.deleteArticle(article);
        assertTrue(rs >= 0);
    }
    
    @Test
    public void testIncreaseHit() throws Exception {
        Integer articleno = 202;
        int rs = service.increaseHit(articleno);
        assertTrue(rs >= 0);
    }
    
    @Test
    public void testGetNextArticle() throws Exception {
        String boardcd = "free";
        Integer articleno = 100;
        String searchWord = "";
        List<ModelArticle> rs = service.getNextArticle(boardcd, articleno, searchWord);
        articleno = rs.get(0).getArticleno();
        assertEquals(new Integer(101), articleno);
    }
    
    @Test
    public void testGetPrevArticle() throws Exception {
        String boardcd = "free";
        Integer articleno = 100;
        String searchWord = "";
        List<ModelArticle> rs = service.getPrevArticle(boardcd, articleno, searchWord);
        articleno = rs.get(0).getArticleno();
        assertEquals(new Integer(99), articleno);
    }
    
    @Test
    public void testGetAttachFile() throws Exception {
        fail("Not yet implemented");
    }
    
    @Test
    public void testGetAttachFileList() throws Exception {
        fail("Not yet implemented");
    }
    
    @Test
    public void testInsertAttachFile() throws Exception {
        fail("Not yet implemented");
    }
    
    @Test
    public void testDeleteAttachFile() throws Exception {
        fail("Not yet implemented");
    }
    
    @Test
    public void testGetComment() throws Exception {
        fail("Not yet implemented");
    }
    
    @Test
    public void testGetCommentList() throws Exception {
        fail("Not yet implemented");
    }
    
    @Test
    public void testInsertComment() throws Exception {
        fail("Not yet implemented");
    }
    
    @Test
    public void testUpdateComment() throws Exception {
        fail("Not yet implemented");
    }
    
    @Test
    public void testDeleteComment() throws Exception {
        fail("Not yet implemented");
    }
    
}
