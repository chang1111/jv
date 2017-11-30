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
import board.model.ModelAttachFile;
import board.model.ModelBoard;
import board.model.ModelComments;
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
        javax.sql.DataSource dataSource = (javax.sql.DataSource)context.getBean("dataSource");
        
        org.apache.ibatis.jdbc.ScriptRunner runner = new
        org.apache.ibatis.jdbc.ScriptRunner( dataSource.getConnection() );
        runner.setAutoCommit(true);
        runner.setStopOnError(true);
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        String sf = cl.getResource("ddl/board.ddl.mysql.sql").getFile();
        java.io.Reader br = new java.io.BufferedReader( new java.io.FileReader(sf) );
        runner.runScript( br);
        runner.closeConnection();
    }
    
    @Test
    public void test01GetBoardName() throws Exception {
        String boardcd = "data";
        String rs = service.getBoardName(boardcd);
        assertEquals("자료실", rs);
    }
    
    @Test
    public void test02GetBoardOne() throws Exception {
        String boardcd = "qna";
        List<ModelBoard> rs = service.getBoardOne(boardcd);
        String boardnm = rs.get(0).getBoardnm();
        int UseYN = rs.get(0).getUseYN();
        assertEquals("QnA게시판", boardnm);
        assertEquals(1, UseYN);
    }
    
    @Test
    public void test03GetBoardList() throws Exception {
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
    public void test04InsertBoard() throws Exception {
        ModelBoard board = new ModelBoard();
        board.setBoardcd("notice");
        board.setBoardnm("공자사항");
        board.setUseYN(1);
        int rs = service.insertBoard(board);
        assertTrue(rs >= 1);
    }
    
    @Test
    public void test05UpdateBoard() throws Exception {
        ModelBoard whereValue = new ModelBoard();
        ModelBoard setValue = new ModelBoard();
        whereValue.setBoardcd("notice");
        whereValue.setBoardnm("공자사항");
        setValue.setBoardnm("공자사항");
        setValue.setUpdateUID(null);
        setValue.setUseYN(1);
        setValue.setUpdateDT(null);
        int rs = service.updateBoard(whereValue, setValue);
        assertTrue(rs >= 0);
    }
    
    @Test
    public void test06DeleteBoard() throws Exception {
        ModelBoard board = new ModelBoard();
        board.setBoardcd("notice");
        int rs = service.deleteBoard(board);
        assertTrue(rs >= 0);
    }
    
    @Test
    public void test07GetBoardSearch() throws Exception {
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
    public void test08GetBoardTotalRecord() throws Exception {
        String boardcd = "";
        String searchWord = "";
        int rs = service.getBoardTotalRecord(boardcd, searchWord);
        assertEquals(3, rs);
    }
    
    @Test
    public void test09GetBoardPaging() throws Exception {
        String boardcd = "";
        String searchWord = "";
        Integer start = 1;
        Integer end = 3;
        List<ModelBoard> rs = service.getBoardPaging(boardcd, searchWord, start, end);
        assertEquals(3, rs.size());
    }
    
    @Test
    public void test10InsertBoardList() throws Exception {
        List<ModelBoard> item = new ArrayList<ModelBoard>();
        item.add(new ModelBoard());
        item.add(new ModelBoard());
        item.get(0).setBoardcd("notice");
        item.get(0).setBoardnm("공지사항");
        item.get(0).setUseYN(1);
        item.get(1).setBoardcd("notice2");
        item.get(1).setBoardnm("공지사항2");
        item.get(1).setUseYN(1);
        int rs = service.insertBoardList(item);
        assertTrue(rs >= 1);
    }
    
    @Test
    public void test11GetArticleTotalRecord() throws Exception {
        String boardcd = "free";
        String searchWord = "test";
        int rs = service.getArticleTotalRecord(boardcd, searchWord);
        assertEquals(201, rs);
    }

    @Test
    public void test12GetArticleList() throws Exception {
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
    public void test13GetArticle() throws Exception {
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
    public void test14InsertArticle() throws Exception {
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
    public void test15UpdateArticle() throws Exception {
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
    public void test16DeleteArticle() throws Exception {
        ModelArticle article = new ModelArticle();
        article.setArticleno(202);
        int rs = service.deleteArticle(article);
        assertTrue(rs >= 0);
    }
    
    @Test
    public void test17IncreaseHit() throws Exception {
        Integer articleno = 202;
        int rs = service.increaseHit(articleno);
        assertTrue(rs >= 0);
    }
    
    @Test
    public void test18GetNextArticle() throws Exception {
        String boardcd = "free";
        Integer articleno = 100;
        String searchWord = "";
        List<ModelArticle> rs = service.getNextArticle(boardcd, articleno, searchWord);
        articleno = rs.get(0).getArticleno();
        assertEquals(new Integer(101), articleno);
    }
    
    @Test
    public void test19GetPrevArticle() throws Exception {
        String boardcd = "free";
        Integer articleno = 100;
        String searchWord = "";
        List<ModelArticle> rs = service.getPrevArticle(boardcd, articleno, searchWord);
        articleno = rs.get(0).getArticleno();
        assertEquals(new Integer(99), articleno);
    }
    
    @Test
    public void test20GetAttachFile() throws Exception {
        Integer attachfileno = 1;
        List<ModelAttachFile> rs = service.getAttachFile(attachfileno);
        String filename = rs.get(0).getFilename();
        String filetype = rs.get(0).getFiletype();
        Integer filesize = rs.get(0).getFilesize();
        Integer articleno = rs.get(0).getArticleno();
        assertEquals("어태치파일", filename);
        assertEquals("파일타입", filetype);
        assertEquals(new Integer(10), filesize);
        assertEquals(new Integer(1), articleno);
    }
    
    @Test
    public void test21GetAttachFileList() throws Exception {
        Integer articleno = 1;
        List<ModelAttachFile> rs = service.getAttachFileList(articleno);
        assertEquals(7, rs.size());
    }
    
    @Test
    public void test22InsertAttachFile() throws Exception {
        ModelAttachFile attachfile = new ModelAttachFile();
        attachfile.setFilename("attachfile");
        attachfile.setFiletype("filetype");
        attachfile.setFilesize(50);
        attachfile.setArticleno(2);
        int rs = service.insertAttachFile(attachfile);
        assertTrue(rs >= 1);
    }
    
    @Test
    public void test23DeleteAttachFile() throws Exception {
        ModelAttachFile attachfile = new ModelAttachFile();
        attachfile.setAttachfileno(8);
        int rs = service.deleteAttachFile(attachfile);
        assertTrue(rs >= 0);
    }
    
    @Test
    public void test24GetComment() throws Exception {
        Integer commentno = 1;
        List<ModelComments> rs = service.getComment(commentno);
        assertEquals(new Integer(1), rs.get(0).getArticleno());
        assertEquals("aa@aa.co.kr", rs.get(0).getEmail());
        assertEquals("comment test", rs.get(0).getMemo());
    }
    
    @Test
    public void test25GetCommentList() throws Exception {
        Integer articleno = 1;
        List<ModelComments> rs = service.getCommentList(articleno);
        assertEquals(new Integer(1), rs.get(0).getCommentno());
        assertEquals("aa@aa.co.kr", rs.get(0).getEmail());
        assertEquals("comment test", rs.get(0).getMemo());
    }
    
    @Test
    public void test26InsertComment() throws Exception {
        ModelComments comments = new ModelComments();
        comments.setArticleno(2);
        comments.setEmail("aa@aa.com");
        comments.setMemo("test");
        comments.setInsertUID(null);
        comments.setUpdateUID(null);
        int rs = service.insertComment(comments);
        assertTrue(rs >= 1);
    }
    
    @Test
    public void test27UpdateComment() throws Exception {
        ModelComments whereValue = new ModelComments();
        ModelComments setValue = new ModelComments();
        whereValue.setCommentno(2);
        setValue.setMemo("update test");
        setValue.setRegdate(new java.util.Date());
        setValue.setUseYN(1);
        int rs = service.updateComment(whereValue, setValue);
        assertTrue(rs >= 0);
    }
    
    @Test
    public void test28DeleteComment() throws Exception {
        ModelComments comments = new ModelComments();
        comments.setCommentno(2);
        int rs = service.deleteComment(comments);
        assertTrue(rs >= 0);
    }
    
}
