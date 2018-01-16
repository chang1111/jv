package example.com.serialization;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        textView = findViewById(R.id.textView);

        // 이전 activity에서 intent 받기
        Intent intent = getIntent();

        String d1 = intent.getStringExtra("data");
        if (d1!=null&&!d1.isEmpty())
            textView.setText(textView.getText() + " : " + d1 + "\n");

        int[] array = intent.getIntArrayExtra("data");
        if (array != null)
            textView.setText(array[0] + ", " + array[1] + ", " + array[2] + ", " + array[3] + ", " + array[4]);

        ModelSerial serial = (ModelSerial) intent.getSerializableExtra("serial");
        if (serial != null)
            textView.setText(serial.getIdata() + ", " + serial.getSdata());
    }
}
