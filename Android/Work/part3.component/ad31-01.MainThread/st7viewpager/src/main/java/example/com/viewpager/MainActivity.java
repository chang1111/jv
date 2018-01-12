package example.com.viewpager;

import android.content.Context;
import android.os.SystemClock;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button play;
    private Button pause;
    private ViewPager viewPager;
    private Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = findViewById(R.id.play);
        pause = findViewById(R.id.pause);
        viewPager = findViewById(R.id.viewPager);
        MyPagerAdapter adapter = new MyPagerAdapter(MainActivity.this);
        viewPager.setAdapter(adapter);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thread.start();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thread.stop();
            }
        });

        thread = new Thread() {
            @Override
            public void run() {
                for (;;) {

                    // 메인쓰레드로 보낼 메시지 작성

                    // 메시지 작성 방법
                    // 1. Runnable : 실행 코드를 전달할 때
                    // 2. Handler : 문자열이나 값을 전달할 때


                    Runnable message = new Runnable() {
                        @Override
                        public void run() {
                            if (viewPager.getCurrentItem() == 4) {
                                viewPager.setCurrentItem(0, true);
                            }
                            else {
                                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
                            }
                        }
                    };
                    // work thread에서 main thread로 메시지 전송
                    MainActivity.this.runOnUiThread(message);
                    // time delay : 1초 동안
                    SystemClock.sleep(1000);

                }
            }
        };
    }

    private class MyPagerAdapter extends PagerAdapter {
        LayoutInflater inflater;
        public MyPagerAdapter(Context context) {
            inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        private int images[] = {
                  R.drawable.mov00
                , R.drawable.mov01
                , R.drawable.mov02
                , R.drawable.mov03
                , R.drawable.mov04
                , R.drawable.mov05
                , R.drawable.mov06
                , R.drawable.mov07
                , R.drawable.mov08
                , R.drawable.mov09
                , R.drawable.mov10
                , R.drawable.mov11
                , R.drawable.mov12
                , R.drawable.mov13
                , R.drawable.mov14
                , R.drawable.mov15
                , R.drawable.mov16
                , R.drawable.mov17
                , R.drawable.mov18
                , R.drawable.mov19
        };

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = inflater.inflate(R.layout.view, null, false);
            ImageView image = view.findViewById(R.id.image);
            image.setImageResource(images[(int)(20*Math.random())]);
            container.addView(view);

            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }
    }
}
