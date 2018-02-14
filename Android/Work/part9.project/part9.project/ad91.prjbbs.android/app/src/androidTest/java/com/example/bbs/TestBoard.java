package com.example.bbs;

import android.support.test.runner.AndroidJUnit4;

import com.example.bbs.http.*;
import com.example.bbs.model.*;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@FixMethodOrder(org.junit.runners.MethodSorters.NAME_ASCENDING)
public class TestBoard {

    private static HttpBoard http = null;

    @BeforeClass
    public static void Setup() {
        http = new HttpBoard();
    }

    @Test
    public void test00_() throws Exception {

    }


    @Test
    public void test01_getBoardName() throws Exception {
        String result = http.getBoardName("free");
        assertEquals("자유게시판", result);
    }


    @Test
    public void test02_getBoardOne() throws Exception {

    }

    @Test
    public void test03_getBoardTotalRecord() throws Exception {

    }

    @Test
    public void test04_getBoardPaging() throws Exception {

    }


    @Test
    public void test05_getBoardList() throws Exception {

        List<ModelBoard> result = http.getBoardList("");
        assertNotNull(result);
        assertTrue(result.size()>0 );
    }

    @Test
    public void test06_insertBoard() throws Exception {

    }

    @Test
    public void test07_insertBoardList() throws Exception {

    }

    @Test
    public void test08_updateBoard() throws Exception {

    }

    @Test
    public void test09_deleteBoard() throws Exception {

    }

    @Test
    public void test11_getArticleList() throws Exception {

        List<ModelArticle> result = http.getArticleList("free", "", 1, 1000);
        assertNotNull(result);
        assertTrue(result.size()>0 );

    }

    @Test
    public void test12_getArticle() throws Exception {

        ModelArticle result = http.getArticle(1);
        assertNotNull(result);
        assertTrue(1 == result.getArticleno() );

    }

    @Test
    public void test13_insertArticle() throws Exception {

        ModelArticle article = new ModelArticle();
        int result = http.insertArticle(article);
        assertTrue(1 == result );
    }

    @Test
    public void test14_updateArticle() throws Exception {

        ModelArticle setValue = new ModelArticle();
        ModelArticle whereValue = new ModelArticle();

        int result = http.updateArticle(setValue, whereValue);
        assertTrue(1 == result );
    }

    @Test
    public void test15_deleteArticle() throws Exception {

        ModelArticle article = new ModelArticle();
        int result = http.deleteArticle(article);
        assertTrue(1 == result );
    }

    @Test
    public void test21_getComment() throws Exception {

        ModelComments result = http.getComment(1);
        assertNotNull(result);
        assertTrue(1 == result.getArticleno() );
    }

    @Test
    public void test22_getCommentList() throws Exception {

        List<ModelComments> result = http.getCommentList(1 );
        assertNotNull(result);
        assertTrue(result.size()>0 );
    }

    @Test
    public void test23_insertComment() throws Exception {

        ModelComments comment = new ModelComments();
        int result = http.insertComment(comment);
        assertTrue(1 == result );
    }

    @Test
    public void test24_updateComment() throws Exception {

        ModelComments setValue = new ModelComments();
        ModelComments whereValue = new ModelComments();

        int result = http.updateComment(setValue, whereValue);
        assertTrue(1 == result );
    }

    @Test
    public void test25_deleteComment() throws Exception {

        ModelComments article = new ModelComments();
        int result = http.deleteComment(article);
        assertTrue(1 == result );
    }
}
