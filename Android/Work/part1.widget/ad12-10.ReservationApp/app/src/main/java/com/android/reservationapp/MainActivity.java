package com.android.reservationapp;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    private TextView textView = null;
    private Button button = null;
    private RadioGroup rdoGroup = null;
    private RadioButton rdoDate = null;
    private DatePicker datePicker = null;
    private TimePicker timePicker = null;
    private Button button2 = null;
    private TextView textView2 = null;
    private Chronometer chronometer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        rdoGroup = findViewById(R.id.rdoGroup);
        rdoDate = findViewById(R.id.rdoDate);
        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);
        button2 = findViewById(R.id.button2);
        textView2 = findViewById(R.id.textView2);
        chronometer = findViewById(R.id.chronometer);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.start();
                button.setEnabled(false);
                button2.setEnabled(true);
            }
        });

        rdoGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (rdoDate.isChecked()) {
                    datePicker.setVisibility(View.VISIBLE);
                    timePicker.setVisibility(View.GONE);
                }
                else {
                    datePicker.setVisibility(View.GONE);
                    timePicker.setVisibility(View.VISIBLE);
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.stop();
                textView.setText("예약에 걸린 시간 " + chronometer.getText().toString());

                int yy = datePicker.getYear();
                int mm = datePicker.getMonth() + 1;
                int dd = datePicker.getDayOfMonth();
                int hh = timePicker.getCurrentHour();
                int mi = timePicker.getCurrentMinute();
                textView2.setText(yy + "년 " + mm + "월 " + dd + "일 " + hh + "시 " + mi + "분 예약됨");
                chronometer.setBase(SystemClock.elapsedRealtime());
                button.setEnabled(true);
                button2.setEnabled(false);
            }
        });
    }
}
