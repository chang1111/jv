package com.android.eventlistener;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button anonymous = null;
    private Button inner = null;
    private Button implement = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anonymous = findViewById(R.id.anonymous);
        anonymous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getApplicationContext(), "무명 클래스 리스너", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        inner = findViewById(R.id.inner);
        inner.setOnClickListener(new InnerClass());

        implement = findViewById(R.id.implement);
        implement.setOnClickListener(this);
    }

    public void inlineclick(View view) {
        Toast toast = Toast.makeText(getApplicationContext(), "인라인 리스너", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onClick(View view) {
        Toast toast = Toast.makeText(getApplicationContext(), "IMPLEMENT 리스너", Toast.LENGTH_SHORT);
        toast.show();
    }

    private class InnerClass implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            int id = view.getId(); // 클릭된 버튼 id (int 값)
            switch (id) {
                case R.id.anonymous:
                    break;
                case R.id.inline:
                    break;
                case R.id.inner:
                    break;
                case R.id.implement:
                    break;
            }

            Toast toast = Toast.makeText(getApplicationContext(), "내부 클래스 리스너", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
