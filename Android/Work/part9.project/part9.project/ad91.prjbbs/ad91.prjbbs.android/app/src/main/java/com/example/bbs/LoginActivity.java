package com.example.bbs;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.content.Intent; // 직접 타이핑

import com.example.bbs.http.HttpPerson;

public class LoginActivity extends AppCompatActivity  {

    // 위젯선언
    private Button btnLogin;
    private EditText edtID;
    private EditText edtPW;
    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // 위젯 찾기
        edtID = findViewById(R.id.edtID);
        edtPW = findViewById(R.id.edtPW);
        btnLogin = findViewById(R.id.btnLogin);

        // Preference 객체 얻기. 파일이름은 Settings.xml
        pref = getSharedPreferences( AppConstants.FILE_PREFERECE, MODE_PRIVATE);
        String id = pref.getString( AppConstants.LOGIN_ID, "");
        //String pw = pref.getString("LOGIN_PW", "");

        edtID.setText( id );

        // 위젯 설정.
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = edtID.getText().toString();
                String pw = edtPW.getText().toString();
                if ( !id.isEmpty() && !pw.isEmpty()) {
                    new LoginTask(LoginActivity.this).execute(id, pw);
                }
                else {
                    // message 출력
                }
            }
        });

    }

    private class LoginTask extends SiteAsyncTask<String, Integer, Boolean> {

        public LoginTask(Context context) {
            super(context);
        }

        @Override
        protected Boolean doInBackground(String... strings) {
            long result = -1;

            // id = strings[0]
            // pw = strings[1]
            result = new HttpPerson().loginperson(strings[0], strings[1]);

            if (result > 0) {
                return true;
            }
            else {
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);

            if( result == true ) {
                // 로그인 성공시

                // Preference에 id와 pw 저장.
                SharedPreferences.Editor setter = pref.edit();
                setter.putString( AppConstants.LOGIN_ID, edtID.getText().toString());
                //setter.putString("LOGIN_PW", edtPW.getText().toString());
                setter.putBoolean( AppConstants.LOGIN_STATUS, true);
                setter.apply(); // 저장.

                //메인화면으로 정보를 보낸다.
                // 결과 반환 코드 작성.
                Intent data = new Intent();
                // Intent 에 반환값 저장.
                data.putExtra(AppConstants.LOGIN_STATUS, true);
                // 결과반환.
                setResult(RESULT_OK, data);

                // 실행되고 있는 activiyt(화면) 종료
                finish();
            }
            else {
                // 로그인 실패시
                Toast.makeText(LoginActivity.this, R.string.error_login_fail, Toast.LENGTH_SHORT).show();
            }
        }
    }
}

