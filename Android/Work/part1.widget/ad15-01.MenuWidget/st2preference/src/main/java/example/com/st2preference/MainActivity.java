package example.com.st2preference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private CheckBox chkSound = null;
    private EditText edtNumber = null;
    private EditText edtText = null;
    private Button btnSave = null;
    SharedPreferences pref = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chkSound = findViewById(R.id.chkSound);
        edtNumber = findViewById(R.id.edtNumber);
        edtText = findViewById(R.id.edtText);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = pref.edit();

                editor.putBoolean("SOUND_SET", chkSound.isChecked());
                editor.putInt("TEXT_NUMBER", Integer.valueOf(edtNumber.getText().toString()));
                editor.putString("TEXT_STRING", edtText.getText().toString());
                editor.apply(); // 저장
            }
        });

        //  Preference 객체 얻기. 파일 이름 : Settings.xml
        pref = getSharedPreferences("Settings", MODE_PRIVATE);

        Boolean chk = pref.getBoolean("SOUND_SET", false);
        Integer number = pref.getInt("TEXT_NUMBER", 0);
        String txt = pref.getString("TEXT_STRING", "");

        chkSound.setChecked(chk);
        edtNumber.setText(number.toString());
        edtText.setText(txt);
    }
}
