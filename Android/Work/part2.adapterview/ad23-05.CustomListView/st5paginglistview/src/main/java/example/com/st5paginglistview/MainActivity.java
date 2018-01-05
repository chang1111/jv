package example.com.st5paginglistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linearLayout;
    private ScrollView scrollView;
    private int i = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollView = findViewById(R.id.scrollView);
        linearLayout = findViewById(R.id.linearLayout);

        scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                if (linearLayout.getHeight() == scrollView.getHeight() + scrollView.getScrollY()) {
                    LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

                    CustomView view = new CustomView(getApplicationContext());

                    ImageView image = view.findViewById(R.id.image);
                    TextView name = view.findViewById(R.id.name);
                    TextView price = view.findViewById(R.id.price);
                    TextView description = view.findViewById(R.id.description);

                    image.setImageResource(R.drawable.icon05);
                    name.setText("추억의 테트리스 " + ++i);
                    price.setText("900원");
                    description.setText("aaaa " + i);

                    view.setLayoutParams(lp);

                    linearLayout.addView(view);
                }

            }
        });

    }

}
