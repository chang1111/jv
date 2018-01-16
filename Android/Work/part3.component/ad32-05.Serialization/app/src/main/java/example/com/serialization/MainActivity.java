package example.com.serialization;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButtonHandler buttonHandler = new ButtonHandler();

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);

        btn1.setOnClickListener(buttonHandler);
        btn2.setOnClickListener(buttonHandler);
        btn3.setOnClickListener(buttonHandler);
        btn4.setOnClickListener(buttonHandler);
        btn5.setOnClickListener(buttonHandler);
    }

    private class ButtonHandler implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, SubActivity.class);
            switch (view.getId()) {
                case R.id.btn1:
                    // 기본 타입을 이용한 데이터 전달
                    intent.putExtra("data", "test");
                    break;
                case R.id.btn2:
                    // 배열을 이용한 데어터 전달
                    int[] array = {0, 1, 2, 3, 4};
                    intent.putExtra("data", array);
                    break;
                case R.id.btn3:
                    // SERIALIZABLE을 이용한 데어터 전달
                    ModelSerial serial = new ModelSerial(10, "serial");
                    intent.putExtra("serial",serial);
                    break;
                case R.id.btn4:
                    // PARCELABLE을 이용한 데어터 전달
                    break;
                case R.id.btn5:
                    // BUNDLE을 이용한 데어터 전달
                    break;
            }
            startActivity(intent);
        }
    }
}
