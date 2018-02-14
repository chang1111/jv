package com.example.bbs.article;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.bbs.AppConstants;
import com.example.bbs.R;
import com.example.bbs.SiteAsyncTask;
import com.example.bbs.fragment.FragmentArticle;
import com.example.bbs.http.HttpBoard;
import com.example.bbs.model.ModelBoard;

import java.util.List;

public class ArticleListActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private ArticlePagerAdapter mAdapter;
    private List<ModelBoard> mDataBoardList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_list);

        //setActivity();
        new BoardTask( ArticleListActivity.this).execute("");
    }

    private void setActivity() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // TabLayout 설정
        mTabLayout = findViewById(R.id.tab_layout);

        for( int i=0; i<mDataBoardList.size(); i++) {

            TabLayout.Tab tab = mTabLayout.newTab()
                    .setText( mDataBoardList.get(i).getBoardnm() )
                    .setIcon( getResources().getDrawable( AppConstants.icons[ i % AppConstants.icons.length ], null ) );

            mTabLayout.addTab( tab );
        }

        // Activity 타이틀 설정
        if( mDataBoardList != null && mDataBoardList.size() > 0 )
            setTitle( mDataBoardList.get( 0 ).getBoardnm() );
        else
            setTitle( R.string.TITLE_ARTICLE );


        // ViewPager 설정
        mViewPager = findViewById(R.id.view_pager);
        mAdapter = new ArticlePagerAdapter( getSupportFragmentManager(), mDataBoardList );
        mViewPager.setAdapter( mAdapter );
        mViewPager.setOffscreenPageLimit( mAdapter.getCount() - 1  );

        // ViewPager 와 TabLayout 의 연동 설정. ViewPager를 스크롤하면 Tab도 같이 바뀌게.
        mViewPager.addOnPageChangeListener( new TabLayout.TabLayoutOnPageChangeListener( mTabLayout ) );

        // TabLayout과 ViewPager 의 연동 설정 : Tab을 변경하면 ViewPager도 같이 바뀌게
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem( tab.getPosition() );

                // 타이틀 변경
                ArticleListActivity.this.setTitle( mDataBoardList.get( tab.getPosition() ).getBoardnm() );
            }
            @Override public void onTabUnselected(TabLayout.Tab tab) { }
            @Override public void onTabReselected(TabLayout.Tab tab) { }
        });
    }

    private class BoardTask extends SiteAsyncTask< String, Integer, List<ModelBoard> > {

        public BoardTask(Context context) {
            super(context);
        }

        @Override
        protected List<ModelBoard> doInBackground(String... strings) {
            List<ModelBoard> result = new HttpBoard().getBoardList("");
            return result;
        }

        @Override
        protected void onPostExecute(List<ModelBoard> list) {
            super.onPostExecute(list);

            mDataBoardList = list;

            // Activity 화면 설정
            setActivity();
        }
    }

    private class ArticlePagerAdapter extends FragmentPagerAdapter {

        private final List<ModelBoard> mBoardList;

        public ArticlePagerAdapter(FragmentManager fm, List<ModelBoard> boardList ) {
            super(fm);
            this.mBoardList = boardList;
        }

        @Override
        public int getCount() {
            return mBoardList.size();
        }

        @Override
        public Fragment getItem(int position) {
            if( mBoardList.size() > position)
                return FragmentArticle.newInstance( mBoardList.get(position) );
            else
                return null;
        }
    }
}
