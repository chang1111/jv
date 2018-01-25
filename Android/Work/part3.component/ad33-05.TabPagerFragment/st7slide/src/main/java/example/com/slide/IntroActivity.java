package example.com.slide;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.content.Intent;
import android.widget.TextView;

public class IntroActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private LinearLayout mLayoutDots;
    private Button mBtnSkip;
    private Button mBtnNext;

    private PrefManager mPref;
    private int[] mLayout = {
            R.layout.welcome_slide1,
            R.layout.welcome_slide2,
            R.layout.welcome_slide3,
            R.layout.welcome_slide4
    };
    private SlidePagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPref = new PrefManager(IntroActivity.this);

        // SharedPreference 이용하여 firstLaunch 값 체크
        if (mPref.isFirstTimeLaunch()) {
            // 인트로 화면 모두 본 경우에는 다시 IntroActivity를 출력하지 않는다
            launchMain();
        }

        setContentView(R.layout.activity_intro);

        mViewPager = findViewById(R.id.view_pager);
        mLayoutDots = findViewById(R.id.layout_dots);
        mBtnSkip = findViewById(R.id.btn_skip);
        mBtnNext = findViewById(R.id.btn_next);

        // 위젯 설정, 리스너, 어댑터
        adapter = new SlidePagerAdapter(IntroActivity.this);
        mViewPager.setAdapter(adapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                addBottomDots(position);

                //
                if (position == mLayout.length -1) {
                    mBtnNext.setText(R.string.end);
                }
                else {
                    mBtnNext.setText(R.string.next);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        ButtonListener bListener = new ButtonListener();

        mBtnSkip.setOnClickListener(bListener);
        mBtnNext.setOnClickListener(bListener);

        // 바닥에 있는 .... 만들기
        addBottomDots(0);

    }

    private void addBottomDots(int currentPage) {
        TextView[] dots = new TextView[mLayout.length];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

        mLayoutDots.removeAllViews();

        for (int i = 0; i < mLayout.length; i++) {
            dots[i] = new TextView(IntroActivity.this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[i]);
            mLayoutDots.addView(dots[i]);
        }
        dots[currentPage].setTextColor(colorsActive[currentPage]);
    }

    public void launchMain() {
        mPref.setFirstTimeLaunch(true);
        startActivity(new Intent(IntroActivity.this, MainActivity.class));
        finish();
    }

    private class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.btn_skip:
                    launchMain();
                    break;
                case R.id.btn_next:
                    int current = mViewPager.getCurrentItem();
                    if (current != adapter.getCount() - 1) {
                        mViewPager.setCurrentItem(current + 1);
                    }
                    else {
                        launchMain();
                    }
                    break;
            }
        }
    }

    private class SlidePagerAdapter extends PagerAdapter {

        LayoutInflater inflater;

        public SlidePagerAdapter(Context context) {
            inflater = LayoutInflater.from(context);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = inflater.inflate(mLayout[position], container, false);

            container.addView(view);

            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }

        @Override
        public int getCount() {
            return mLayout.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }

}
