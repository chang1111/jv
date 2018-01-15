package example.com.startactivityforresult;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;
    private Button btnAdd;
    private TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        btnAdd = findViewById(R.id.btnAdd);
        resultView = findViewById(R.id.resultView);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                int value1 = 0;
                int value2 = 0;
                if (editText1.getText().toString().isEmpty()) {
                    value1 = 0;
                }
                else {
                    value1 = Integer.valueOf(editText1.getText().toString());
                }
                if (editText2.getText().toString().isEmpty()) {
                    value2 = 0;
                }
                else {
                    value2 = Integer.valueOf(editText2.getText().toString());
                }
                intent.putExtra("value1", value1);
                intent.putExtra("value2", value2);
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        int sum = data.getIntExtra("sum", 0);
        resultView.setText("합계 : " + sum);
    }
}
