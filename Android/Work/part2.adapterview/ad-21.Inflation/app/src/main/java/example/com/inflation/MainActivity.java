package example.com.inflation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btn = null;
    private Button btn2 = null;
    private Button btn3 = null;
    LinearLayout parent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                parent = findViewById(R.id.parent);
                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

                inflater.inflate(R.layout.layout_sub1, parent,true);

                CheckBox checkBox = parent.findViewById(R.id.checkBox);
                checkBox.setText("inflation 완료");

                Button btn3 = parent.findViewById(R.id.button3);
                btn3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        TextView textView = findViewById(R.id.textView);
                        textView.setText("버튼 눌림");
                    }
                });
            }
        });
        btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parent = findViewById(R.id.parent);
                LayoutInflater.from(MainActivity.this)
                        .inflate(R.layout.layout_sub1, parent, true);

                CheckBox checkBox = parent.findViewById(R.id.checkBox);
                checkBox.setText("inflation 완료");

                Button btn3 = parent.findViewById(R.id.button3);
                btn3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        TextView textView = findViewById(R.id.textView);
                        textView.setText("버튼 눌림");
                    }
                });
            }
        });
        btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parent = findViewById(R.id.parent);
                View child = LayoutInflater.from(MainActivity.this)
                        .inflate(R.layout.layout_sub1, null);

                parent.addView(child);

                CheckBox checkBox = parent.findViewById(R.id.checkBox);
                checkBox.setText("inflation 완료");

                Button btn3 = parent.findViewById(R.id.button3);
                btn3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        TextView textView = findViewById(R.id.textView);
                        textView.setText("버튼 눌림");
                    }
                });
            }
        });
    }
}
