package example.com.openactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private Button back;
    private TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setTitle("SecondActivity");

        back = findViewById(R.id.back);
        textView1 = findViewById(R.id.textView1);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Intent intent = getIntent();
        String val = intent.getStringExtra("val"); // val --> 1
        textView1.setText(val);
    }
}
