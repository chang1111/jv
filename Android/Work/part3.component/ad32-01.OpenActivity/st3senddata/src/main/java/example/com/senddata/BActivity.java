package example.com.senddata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;

public class BActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        setTitle("B Activity");

        textView = findViewById(R.id.textView);

        Intent intent = getIntent();
        String text = intent.getStringExtra("text");
        textView.setText(text);
    }
}
