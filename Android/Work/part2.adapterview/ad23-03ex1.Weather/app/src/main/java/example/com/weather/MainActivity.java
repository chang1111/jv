package example.com.weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CustomView cloudy;
    private CustomView showers;
    private CustomView snow;
    private CustomView storm;
    private CustomView sunny;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cloudy = findViewById(R.id.cloudy);
        showers = findViewById(R.id.showers);
        snow = findViewById(R.id.snow);
        storm = findViewById(R.id.storm);
        sunny = findViewById(R.id.sunny);

        Handler handler = new Handler();

        cloudy.setOnClickListener(handler);
        showers.setOnClickListener(handler);
        snow.setOnClickListener(handler);
        storm.setOnClickListener(handler);
        sunny.setOnClickListener(handler);


    }

    private class Handler implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            String msg = null;
            msg = ((CustomView)view).getText().getText().toString();
            Toast toast = Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}


