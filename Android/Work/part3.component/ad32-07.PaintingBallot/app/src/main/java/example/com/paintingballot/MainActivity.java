package example.com.paintingballot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 9999;
    private ImageView iv1;
    private ImageView iv2;
    private ImageView iv3;
    private ImageView iv4;
    private ImageView iv5;
    private ImageView iv6;
    private ImageView iv7;
    private ImageView iv8;
    private ImageView iv9;
    private Button btnResult;
    private int[] rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv1 = findViewById(R.id.iv1);
        iv2 = findViewById(R.id.iv2);
        iv3 = findViewById(R.id.iv3);
        iv4 = findViewById(R.id.iv4);
        iv5 = findViewById(R.id.iv5);
        iv6 = findViewById(R.id.iv6);
        iv7 = findViewById(R.id.iv7);
        iv8 = findViewById(R.id.iv8);
        iv9 = findViewById(R.id.iv9);
        btnResult = findViewById(R.id.btnResult);

        Handler handler = new Handler();
        rating = new int[9];

        iv1.setOnClickListener(handler);
        iv2.setOnClickListener(handler);
        iv3.setOnClickListener(handler);
        iv4.setOnClickListener(handler);
        iv5.setOnClickListener(handler);
        iv6.setOnClickListener(handler);
        iv7.setOnClickListener(handler);
        iv8.setOnClickListener(handler);
        iv9.setOnClickListener(handler);

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("rating", rating);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    private class Handler implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.iv1:
                    rating[0]++;
                    break;
                case R.id.iv2:
                    rating[1]++;
                    break;
                case R.id.iv3:
                    rating[2]++;
                    break;
                case R.id.iv4:
                    rating[3]++;
                    break;
                case R.id.iv5:
                    rating[4]++;
                    break;
                case R.id.iv6:
                    rating[5]++;
                    break;
                case R.id.iv7:
                    rating[6]++;
                    break;
                case R.id.iv8:
                    rating[7]++;
                    break;
                case R.id.iv9:
                    rating[8]++;
                    break;
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (REQUEST_CODE == requestCode && requestCode == RESULT_OK) {
            String title = data.getStringExtra("title");

        }

    }
}
