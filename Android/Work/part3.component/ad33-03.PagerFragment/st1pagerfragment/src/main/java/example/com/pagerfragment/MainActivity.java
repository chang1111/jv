package example.com.pagerfragment;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = findViewById(R.id.pager);

        BgPagerAdapter adapter = new BgPagerAdapter(MainActivity.this);
        pager.setAdapter(adapter);
        pager.setOffscreenPageLimit(3);
    }

    private class BgPagerAdapter extends PagerAdapter {

        LayoutInflater inflater;

        public BgPagerAdapter(Context context) {
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

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = null;
            switch (position) {
                case 0:
                    view = inflater.inflate(R.layout.layout0, null, false);
                    break;
                case 1:
                    view = inflater.inflate(R.layout.layout1, null, false);
                    break;
                case 2:
                    view = inflater.inflate(R.layout.layout2, null, false);
                    break;
                case 3:
                    view = inflater.inflate(R.layout.layout3, null, false);
                    break;
                case 4:
                    view = inflater.inflate(R.layout.layout4, null, false);
                    break;
            }

            container.addView(view);

            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }
    }
}
