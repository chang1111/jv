package com.example.bbs.fragment;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.bbs.R;
import com.example.bbs.article.AdapterArticle;
import com.example.bbs.model.ModelArticle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FragmentArticleFree extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private View   mView;

    private ListView           mListView;
    private AdapterArticle mAdapter ;
    private List<ModelArticle> mData;

    private boolean flagGetData = false;


    public FragmentArticleFree() {
        // Required empty public constructor
    }
    
    public static FragmentArticleFree newInstance(String param1, String param2) {
        FragmentArticleFree fragment = new FragmentArticleFree();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        // 타이틀 변경
        getActivity().setTitle(  mParam1 );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView =  inflater.inflate(R.layout.fragment_article_free, container, false);

        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // 위젯 찾기
        mListView = mView.findViewById(R.id.listview_free);


        // 데이터 만들기
        mData = makeData(0, 20);

        // adapter 생성
        mAdapter = new AdapterArticle( getContext(), R.layout.listview_customview_article, mData);

        // adapter 연결
        mListView.setAdapter( mAdapter );

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // AlertDialog 로 출력하기
                ModelArticle item = mData.get( position );

                AlertDialog.Builder builder = new AlertDialog.Builder( getContext() );
                builder.setTitle( item.getTitle() );
                builder.setMessage( item.toString() );
                builder.setIcon( R.mipmap.ic_launcher );
                builder.setPositiveButton("확인", null);
                builder.show();
            }
        });

        // adapter scroll 리스너 설정
        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if( totalItemCount == firstVisibleItem + visibleItemCount ){
                    // 바닥이다.
                    // 데이터 추가.
                    if( flagGetData == false ) {
                        flagGetData = true;

                        // // 1. 네트워크를 통해 데이터 요청
                        // List<ModelItem> items = null;
                        // items = makeData(lists.size(), 20);
                        //
                        // // 2. 통신 완료 후 받은 데이터 작업
                        // lists.addAll( items );
                        // adapter.notifyDataSetChanged();
                        // flagGetData = false;

                        new HttpGetData().execute(mData.size(), 20);
                    }
                }
            }
        });
    }

    private class HttpGetData extends AsyncTask< Integer,  Integer, List<ModelArticle>  > {

        private ProgressDialog pdlg  = null;

        // 요청 전.네트워크로 데이터 요청하기 직전에 실행되는 메서드
        // 사용자에게 요청을 알림 표시. ProgressDialog 표시..
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            // Wait 동안 ProgressDialog 보여 주기
            pdlg = new ProgressDialog( getContext() );
            pdlg.setMessage("데이터 가져오는 중");
            pdlg.show();
        }

        // 요청 중.
        @Override
        protected List<ModelArticle> doInBackground(Integer... integers) {

            List<ModelArticle> items = null;

            try {
                // 4초간 기다리기...  sleep 주기
                //Thread.sleep(4000);
                java.util.concurrent.TimeUnit.SECONDS.sleep( 10 );

                // 1. 네트워크를 통해 데이터 요청
                items = makeData(integers[0], integers[1]);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return items;
        }

        // 요청 후. 네트워크로 데이터 요청이 완료되었을 때 실행되는 메서드
        // 사용자에게 요청을 알림 제거. ProgreesDialog 제거.
        @Override
        protected void onPostExecute(List<ModelArticle> modelItems) {
            super.onPostExecute(modelItems);

            // ProgreesDialog 제거.
            if( pdlg !=null ){
                pdlg.dismiss();
                pdlg = null;
            }

            // 2. 통신 완료 후 받은 데이터 작업
            mData.addAll( modelItems );
            mAdapter.notifyDataSetChanged();

            flagGetData = false;
        }
    }

    private List<ModelArticle> makeData(int start, int count) {

        List<ModelArticle> newitems = new ArrayList<ModelArticle>();

        Random r = new Random();
        for(int i=start; i<start + count; i++){
            ModelArticle model = new ModelArticle();
            model.setArticleno( i );
            model.setTitle( "name " + i );
            model.setHit( 20 + r.nextInt( 3000)  );
            model.setContent( getRandString() );

            newitems.add( model );
        }

        return newitems;
    }

    // 임의의 문자열 만들기.
    private String getRandString() {
        String str = "";
        for (int i = 1; i <= (int) (Math.random()*10000); i++) {
            char ch = (char) ((Math.random() * 11172) + 0xAC00);
            str += String.valueOf( (char) ((Math.random() * 26) + 97) );
        }
        return str;
    }

}