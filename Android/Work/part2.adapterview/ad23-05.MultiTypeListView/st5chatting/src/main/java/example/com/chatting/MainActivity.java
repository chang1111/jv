package example.com.chatting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private EditText text;
    private RadioGroup radioSelect;
    private RadioButton send;
    private RadioButton receive;
    private RadioButton data;
    private Button insert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.text);
        radioSelect = findViewById(R.id.radioSelect);
        send = findViewById(R.id.send);
        receive = findViewById(R.id.receive);
        data = findViewById(R.id.data);
        insert = findViewById(R.id.insert);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (radioSelect.getCheckedRadioButtonId()) {
                    case R.id.send:

                        break;
                    case R.id.receive:
                        break;
                    case R.id.data:
                        break;
                }
            }
        });
    }
}
