package example.com.mainthread;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mCountTextView = null;
    private Handler handler = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCountTextView = findViewById(R.id.textView1);

        // Handler
        // Thread
        // Runnable : 실행도리 코드를 담는 객체(클래스)

        handler = new Handler();

        Thread countThread = new Thread() {
            @Override
            public void run() {
                // 10초 동안 1씩 카운트 한다
                for (int i = 0; i < 10; i++) {

                    // 현재 카운트된 값을 로그로 출력한다.
                    Log.i("superdroid", "Current Count : " + mCount);
                    try {
                        mCount++;
                        // Runnable 생성
                        Runnable message = new Runnable() {
                            @Override
                            public void run() {
                                // 텍스트 뷰에 현재까지 카운트된 수를 출력한다
                                mCountTextView.setText("Count : " + mCount);
                            }
                        };
                        handler.post(message);
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            };

        };

        countThread.start(); // thread 시작
    }
}
