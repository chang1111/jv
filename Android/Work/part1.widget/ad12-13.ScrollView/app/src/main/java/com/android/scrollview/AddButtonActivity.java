package com.android.scrollview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class AddButtonActivity extends AppCompatActivity {

    // 선언
    private Button btnAdd = null;
    private Button btnAdd5 = null;
    private LinearLayout linearLayout = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_button);

        // 찾기
        btnAdd = findViewById(R.id.btnAdd);
        btnAdd5 = findViewById(R.id.btnAdd5);
        linearLayout = findViewById(R.id.linearLayout);

        // 설정
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // step1. LayoutParam 설정. 추가되는 버튼에 대한 LayoutParam 설정

                // step2. 버튼 생성

                // step3. 생성된 버튼을 LinearLayout에 추가. View.addView() 매서드 이용

                // step1
                LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
                lp.setMargins(10, 10, 10, 10);

                // step2
                Button btn = new Button(getApplicationContext());
                btn.setText("push me");
                btn.setLayoutParams(lp);
                btn.setBackgroundColor(Color.DKGRAY);

                // step3
                linearLayout.addView(btn);
            }
        });

        btnAdd5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < 5; i++) {
                    LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
                    lp.setMargins(10, 10, 10, 10);

                    Button btn = new Button(getApplicationContext());
                    btn.setText("push me");
                    btn.setLayoutParams(lp);
                    btn.setBackgroundColor(Color.GRAY);

                    linearLayout.addView(btn);
                }
            }
        });

    }
}
