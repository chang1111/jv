package example.com.fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn0;
    private Button btn1;
    private Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn_image0);
        btn1 = findViewById(R.id.btn_image1);
        btn2 = findViewById(R.id.btn_image2);

        ButtonListener buttonListener = new ButtonListener();

        btn0.setOnClickListener(buttonListener);
        btn1.setOnClickListener(buttonListener);
        btn2.setOnClickListener(buttonListener);
    }

    private class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            // Fragment 찾기
            FragmentThree fragmentthree = (FragmentThree) getSupportFragmentManager().findFragmentById(R.id.fragmentthree);

            switch (view.getId()) {
                case R.id.btn_image0:
                    fragmentthree.update(0);
                    break;
                case R.id.btn_image1:
                    fragmentthree.update(1);
                    break;
                case R.id.btn_image2:
                    fragmentthree.update(2);
                    break;
            }
        }
    }
}
