package com.android.scrollview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;

public class AutoIncrementScrollViewActivity extends AppCompatActivity {

    private ScrollView scrollView = null;
    private LinearLayout linearLayout = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_increment_scroll_view);

        scrollView = findViewById(R.id.scrollView);
        linearLayout = findViewById(R.id.linearLayout);

        scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                if (linearLayout.getHeight() == scrollView.getHeight() + scrollView.getScrollY()) {
                    LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

                    Button btn = new Button(getApplicationContext());

                    btn.setText("추가된 버튼");
                    btn.setLayoutParams(lp);

                    linearLayout.addView(btn);
                }
            }
        });
    }
}
