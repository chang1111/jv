package example.com.progressbar;

import android.os.SystemClock;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar1;
    private Button btnInc;
    private Button btnDec;
    private TextView tvSeek;
    private SeekBar seekBar1;
    private TextView tv1;
    private SeekBar pb1;
    private TextView tv2;
    private SeekBar pb2;
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar1 = findViewById(R.id.progressBar1);
        btnInc = findViewById(R.id.btnInc);
        btnDec = findViewById(R.id.btnDec);
        tvSeek = findViewById(R.id.tvSeek);
        seekBar1 = findViewById(R.id.seekBar1);
        tv1 = findViewById(R.id.tv1);
        pb1 = findViewById(R.id.pb1);
        tv2 = findViewById(R.id.tv2);
        pb2 = findViewById(R.id.pb2);
        button1 = findViewById(R.id.button1);

        ButtonHandler buttonHandler = new ButtonHandler();

        btnInc.setOnClickListener(buttonHandler);
        btnDec.setOnClickListener(buttonHandler);
        button1.setOnClickListener(buttonHandler);

        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tvSeek.setText("진행률 : " + seekBar1.getProgress() + "%" );
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    private class ButtonHandler implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btnInc:
                    progressBar1.incrementProgressBy(10);
                    break;
                case R.id.btnDec:
                    progressBar1.incrementProgressBy(-10);
                    break;
                case R.id.button1:

                    Thread th1 = new Thread() {
                        @Override
                        public void run() {
                            for (int i = pb1.getProgress(); i < pb1.getMax(); i = i + 2) {
                                //work thread에서 main thread로 넘길 메시지
                                Runnable message = new Runnable() {
                                    @Override
                                    public void run() {
                                        // 실행 코드
                                        pb1.setProgress(pb1.getProgress() + 2);
                                        tv1.setText("진행률 : " + pb1.getProgress() + "%" );
                                    }
                                };

                                MainActivity.this.runOnUiThread(message);

                                //delay 추가 : 100ms
                                SystemClock.sleep(100);

                            }
                        }
                    };
                    Thread th2 = new Thread() {
                        @Override
                        public void run() {
                            for (int i = pb2.getProgress(); i < pb2.getMax(); i = i + 1) {
                                //work thread에서 main thread로 넘길 메시지
                                Runnable message = new Runnable() {
                                    @Override
                                    public void run() {
                                        // 실행 코드
                                        pb2.setProgress(pb2.getProgress() + 1);
                                        tv2.setText("진행률 : " + pb2.getProgress() + "%" );
                                    }
                                };

                                MainActivity.this.runOnUiThread(message);

                                //delay 추가 : 100ms
                                SystemClock.sleep(100);

                            }
                        }
                    };
                    th1.start();
                    th2.start();
                    break;
            }
        }
    }
}
