package example.com.openactivity;

import android.content.ComponentName;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class FirstActivity extends AppCompatActivity {

    private Button btn1;
    private Button btn2;
    private Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        setTitle("FirstActivity");

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        ButtonHandler buttonHandler = new ButtonHandler();

        btn1.setOnClickListener(buttonHandler);
        btn2.setOnClickListener(buttonHandler);
        btn3.setOnClickListener(buttonHandler);
    }

    private class ButtonHandler implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch (view.getId()) {
                case R.id.btn1:
                    intent = new Intent(getApplicationContext(), SecondActivity.class);
                    intent.putExtra("val", "1");
                    break;
                case R.id.btn2:
                    intent = new Intent(FirstActivity.this, SecondActivity.class);
                    intent.putExtra("val", "2");
                    break;
                case R.id.btn3:
                    intent = new Intent();
                    ComponentName componentName = new ComponentName("example.com.openactivity", "example.com.openactivity.SecondActivity");
                    intent.setComponent(componentName);
                    intent.putExtra("val", "3");
                    break;
            }
            startActivity(intent);
        }
    }
}
