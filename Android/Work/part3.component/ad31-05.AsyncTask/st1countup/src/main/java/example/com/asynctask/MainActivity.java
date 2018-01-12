package example.com.asynctask;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.text);

        new CountTask().execute(20);
    }

    // CountTask
    private class CountTask extends AsyncTask<Integer, Integer, Boolean> {

        ProgressDialog pdlg;

        @Override
        protected void onPreExecute() {
            pdlg = new ProgressDialog(MainActivity.this);
            pdlg.setMessage("처리중");
            pdlg.getWindow().setGravity(Gravity.TOP);
            pdlg.show();
        }

        @Override
        protected Boolean doInBackground(Integer... integers) {
            int count = 0;
            for (int i = 0; i < integers[0]; i++) {
                publishProgress(count++, i);

                // 1초 delay
                SystemClock.sleep(1000);
            }
            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            text.setText(values[0] + "");
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            if (pdlg != null) {
                pdlg.dismiss();
                pdlg = null;
            }
        }
    }
}
