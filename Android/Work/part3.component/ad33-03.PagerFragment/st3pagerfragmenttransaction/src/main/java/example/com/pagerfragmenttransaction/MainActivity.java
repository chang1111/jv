package example.com.pagerfragmenttransaction;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String FRAGMENT_TAG_ONE = "one";
    private static final String FRAGMENT_TAG_TWO = "two";
    private static final String FRAGMENT_TAG_THREE = "three";
    private Button btn1;
    private Button btn2;
    private Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        ButtonListener buttonListener = new ButtonListener();

        btn1.setOnClickListener(buttonListener);
        btn2.setOnClickListener(buttonListener);
        btn3.setOnClickListener(buttonListener);

    }

    private class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn1:
                    Fragment old = getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG_ONE);

                    if( old == null ) {
                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

                        FragmentOne f = new FragmentOne();

                        ft.replace(R.id.container, f, FRAGMENT_TAG_ONE  );
                        ft.commit();
                    }
                    break;
                case R.id.btn2:
                    Fragment old2 = getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG_TWO);

                    if( old2 == null ) {
                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        FragmentTwo f = FragmentTwo.newInstance();
                        ft.replace(R.id.container, f, FRAGMENT_TAG_TWO  );
                        ft.commit();
                    }
                    break;
                case R.id.btn3:
                    Fragment old3 = getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG_THREE);

                    if( old3 == null ) {
                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        FragmentThree f = FragmentThree.newInstance();
                        ft.replace(R.id.container, f, FRAGMENT_TAG_THREE  );
                        ft.commit();
                    }
                    break;
            }
        }
    }
}
