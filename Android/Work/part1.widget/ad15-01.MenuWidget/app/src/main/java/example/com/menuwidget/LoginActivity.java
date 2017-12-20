package example.com.menuwidget;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;


public class LoginActivity extends AppCompatActivity {

    private Button btnLogin = null;
    private EditText edtId = null;
    private EditText edtPw = null;
    SharedPreferences pref = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtId = findViewById(R.id.edtId);
        edtPw = findViewById(R.id.edtPw);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                if (edtId.getText().toString().trim().equals("111") &&
                        edtPw.getText().toString().trim().equals("111")) {
                    // 로그인 성공
                    SharedPreferences.Editor editor = pref.edit();

                    editor.putString(CommonCode.LOGIN_ID, edtId.getText().toString());
//                    editor.putString("PW", edtPw.getText().toString());
                    editor.putBoolean(CommonCode.LOGIN_STATUS, true);
                    editor.apply();

                    //결과 반환 코드 작성
                    Intent data = new Intent();
                    // Intent에 반환값 저장
                    data.putExtra(CommonCode.LOGIN_STATUS, true);
                    // 결과반환
                    setResult(RESULT_OK, data);

                    finish();
                }
                else {
                    // 로그인 실패
                    Toast.makeText(getApplicationContext(), R.string.login_fail, Toast.LENGTH_SHORT).show();
                }
            }
        });
        pref = getSharedPreferences(CommonCode.FILE_PREFERENCE, MODE_PRIVATE);

        String id = pref.getString(CommonCode.LOGIN_ID, "");
//        String pw = pref.getString("PW", "");

        edtId.setText(id);
//        edtPw.setText(pw);

    }

}

