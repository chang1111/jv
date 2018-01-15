package example.com.intro;

import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

//        Thread thread = new Thread() {
//            @Override
//            public void run() {
//                SystemClock.sleep(3000);
//
//                Intent intent = new Intent(IntroActivity.this, MainActivity.class);
//                IntroActivity.this.finish();
//                startActivity(intent);
//            }
//        };
//        thread.start();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(IntroActivity.this, MainActivity.class);
                startActivity(intent);
                IntroActivity.this.finish();
            }
        }, 3000);
    }
}
