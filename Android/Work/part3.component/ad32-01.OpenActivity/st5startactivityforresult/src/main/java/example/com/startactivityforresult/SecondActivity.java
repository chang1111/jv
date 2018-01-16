package example.com.startactivityforresult;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private Button finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        finish = findViewById(R.id.finish);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();

                int p1 = intent.getIntExtra("p1", 0);
                int p2 = intent.getIntExtra("p2", 0);
                int sum = p1 + p2;
                intent.putExtra("sum", sum);

                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }
}
