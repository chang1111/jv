package example.com.startactivityforresult;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    private Button goBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        goBack = findViewById(R.id.goBack);

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                int value1 = intent.getIntExtra("value1", 0);
                int value2 = intent.getIntExtra("value2", 0);
                int sum = value1 + value2;

                StringBuilder sb = new StringBuilder();
                sb.append("value1 : " + value1);
                sb.append("\n");
                sb.append("value2 : " + value2);
                intent.putExtra("sum", sum);
                setResult(0, intent);

                finish();
            }
        });
    }
}
