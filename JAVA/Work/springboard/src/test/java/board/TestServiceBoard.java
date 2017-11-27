package board;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import board.model.ModelBoard;
import board.service.ServiceBoard;

public class TestServiceBoard {
    
    private static ServiceBoard service = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        ApplicationContext context = new
                ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        
        service = context.getBean("serviceboard", ServiceBoard.class);
        
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
        String boardcd = "free";
        String searchWord = "";
        int rs = service.getBoardTotalRecord(boardcd, searchWord);
        assertEquals(1, rs);
    }
    
    @Test
    public void testGetBoardPaging() throws Exception {
        fail("Not yet implemented");
    }
    
    @Test
    public void testInsertBoardList() throws Exception {
        fail("Not yet implemented");
    }
    
    @Test
    public void testGetArticleTotalRecord() throws Exception {
        fail("Not yet implemented");
    }
    
    @Test
    public void testGetArticle() throws Exception {
        fail("Not yet implemented");
    }
    
    @Test
    public void testInsertArticle() throws Exception {
        fail("Not yet implemented");
    }
    
    @Test
    public void testUpdateArticle() throws Exception {
        fail("Not yet implemented");
    }
    
    @Test
    public void testDeleteArticle() throws Exception {
        fail("Not yet implemented");
    }
    
    @Test
    public void testIncreaseHit() throws Exception {
        fail("Not yet implemented");
    }
    
    @Test
    public void testGetNextArticle() throws Exception {
        fail("Not yet implemented");
    }
    
    @Test
    public void testGetPrevArticle() throws Exception {
        fail("Not yet implemented");
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
