package com.example.bbs.article;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bbs.R;
import com.example.bbs.SiteAsyncTask;
import com.example.bbs.http.*;
import com.example.bbs.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArticleDetailActivity extends AppCompatActivity {

    public static final String ARG_ARTICLENO = "arcticleno";
    private static final String ARG_ARTICLE  = "arcicle";
    private static final String ARG_COMMENTS = "commentlist";

    // 위젯 선언
    private TextView mNo;
    private TextView mTitle;
    private TextView mHit;
    private TextView mContent;
    private ListView mListview;

    private AdapterComment mAdapter;

    // http 통신으로 받은 정보 저장 필드
    ModelArticle  mArticle;
    List<ModelComments> mDataComments;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);

        android.content.Intent i = getIntent();
        int articleno = i.getIntExtra(ARG_ARTICLENO, 0);

        new ArticleDetailTask(ArticleDetailActivity.this).execute( articleno );
    }

    private class ArticleDetailTask extends SiteAsyncTask< Integer, Integer, Map<String, Object>> {

        public ArticleDetailTask(Context context) {
            super(context);
        }

        @Override
        protected Map<String, Object> doInBackground(Integer... integers) {

            HttpBoard http = new HttpBoard();
            ModelArticle        article  = http.getArticle( integers[0] );
            List<ModelComments> comments = http.getCommentList(integers[0]);

            Map<String, Object> map = new HashMap<>();

            map.put(ARG_ARTICLE , article);
            map.put(ARG_COMMENTS, comments );

            return map;
        }

        @Override
        protected void onPostExecute(Map<String, Object> map) {
            super.onPostExecute(map);

            //
            mArticle      = (ModelArticle) map.get(ARG_ARTICLE);
            mDataComments = (List<ModelComments>) map.get(ARG_COMMENTS);

            // 위젯 찾기
            mNo = findViewById(R.id.no);
            mHit = findViewById(R.id.hit);
            mTitle = findViewById(R.id.title);
            mContent = findViewById(R.id.content);
            mListview = findViewById(R.id.listview_comment);

            // 위젯 설정( 리스너)
            mNo.setText( mArticle.getArticleno() + "" );
            mHit.setText( mArticle.getHit()+ "" );
            mTitle.setText( mArticle.getTitle() );
            mContent.setText( mArticle.getContent() );

            // Activity 타이틀 설정.
            setTitle( mArticle.getTitle() );

            // adapter 생성
            mAdapter = new AdapterComment( this.mContext, R.layout.activity_article_detail_customview, mDataComments );

            // adapter 연결
            mListview.setAdapter(mAdapter);
            
        }
    }

}
