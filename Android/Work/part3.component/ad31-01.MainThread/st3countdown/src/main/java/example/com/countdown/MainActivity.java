package example.com.countdown;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView text;
    private Thread thread;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.text);

        thread = new Thread() {
            @Override
            public void run() {
                for (int i = 20; i >= 0; i--){
                    count = i;

                    // 메인쓰레드로 보낼 메시지 작성

                    // 메시지 작성 방법
                    // 1. Runnable : 실행 코드를 전달할 때
                    // 2. Handler : 문자열이나 값을 전달할 때


                    Runnable message = new Runnable() {
                        @Override
                        public void run() {
                            text.setText(count + "");
                        }
                    };
                    // work thread에서 main thread로 메시지 전송
                    MainActivity.this.runOnUiThread(message);
                    // time delay : 1초 동안
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };
        thread.start();
    }
}
