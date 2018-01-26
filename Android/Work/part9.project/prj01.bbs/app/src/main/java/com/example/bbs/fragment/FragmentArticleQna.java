package com.example.bbs.fragment;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.bbs.R;
import com.example.bbs.model.ModelPerson;
import com.example.bbs.person.AdapterPerson;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentArticleQna#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentArticleQna extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private View mView;
    private ListView mListView;
    private AdapterPerson mAdapter;
    private List<ModelPerson> mData;
    private boolean flagGetData = false;

    public FragmentArticleQna() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentArticleQna.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentArticleQna newInstance(String param1, String param2) {
        FragmentArticleQna fragment = new FragmentArticleQna();
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

        // Activity의 타이틀 변경
        getActivity().setTitle(mParam1);

        // 위젯 찾기
        mListView = mView.findViewById(R.id.listview_qna);

        // 데이터 만들기
        mData = makeData();

        // adatper 생성.
        mAdapter = new AdapterPerson(getContext(), R.layout.listview_customview_person,  mData );

        // adapter 리스너 설정

        // listview와 adatpe 연결
        mListView.setAdapter( mAdapter );


    }

    @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_article_qna, container, false);

        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
    private List<ModelPerson> makeData() {
        List<ModelPerson> items = new ArrayList<>();

        Random r = new Random();
        ModelPerson person;
        for( int i=0; i<20; i++) {
            person = new ModelPerson();
            person.setImageCheck( false );
            person.setTextName( "name " + i );

            person.setTextAge( i + " "+ r.nextInt( 30) );
            Drawable d  = getResources().getDrawable(  images[  i % images.length  ] , null);
            person.setImagePhoto( d );

            items.add( person );
        }

        return items;
    }

    private int[] images = {
            R.drawable.sample_0
            , R.drawable.sample_1
            , R.drawable.sample_2
            , R.drawable.sample_3
            , R.drawable.sample_4
            , R.drawable.sample_5
            , R.drawable.sample_6
            , R.drawable.sample_7
    };

}
