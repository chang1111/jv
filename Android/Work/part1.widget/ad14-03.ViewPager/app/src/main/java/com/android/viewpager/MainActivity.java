package com.android.viewpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn1 = null;
    Button btn2 = null;
    Button btn3 = null;
    ViewPager viewPager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        viewPager = findViewById(R.id.viewPager);

        Handler handler = new Handler();
        btn1.setOnClickListener(handler);
        btn2.setOnClickListener(handler);
        btn3.setOnClickListener(handler);

        MypagerAdaptor adaptor = new MypagerAdaptor(getApplication());
        viewPager.setAdapter(adaptor);

    }

    private class Handler implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn1:
                    viewPager.setCurrentItem(0, true);
                    break;
                case R.id.btn2:
                    viewPager.setCurrentItem(1, true);
                    break;
                case R.id.btn3:
                    viewPager.setCurrentItem(2, true);
                    break;
            }
        }
    }

    private class MypagerAdaptor extends PagerAdapter {

        private LayoutInflater inflater = null;

        public MypagerAdaptor(Context c) {
            this.inflater = LayoutInflater.from(c);
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View v = null;

            switch (position) {
                case 0:
                    v = inflater.inflate(R.layout.inflater_one, null, false);
                    break;
                case 1:
                    v = inflater.inflate(R.layout.inflater_two, null, false);
                    break;
                case 2:
                    v = inflater.inflate(R.layout.inflater_three, null, false);
            }
            viewPager.addView(v);
            return v;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            viewPager.removeView((View)object);
        }
    }
}
