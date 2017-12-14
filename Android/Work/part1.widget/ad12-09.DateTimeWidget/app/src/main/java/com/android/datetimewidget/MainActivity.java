package com.android.datetimewidget;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.DigitalClock;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private AnalogClock clock1 = null;
    private DigitalClock clock2 = null;
    private Chronometer chronometer = null;
    private TimePicker timePicker1 = null;
    private TimePicker timePicker2 = null;
    private DatePicker datePicker1 = null;
    private DatePicker datePicker2 = null;
    private CalendarView calendarView = null;
    private Button btn1 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clock1 = findViewById(R.id.clock1);
        clock2 = findViewById(R.id.clock2);
        chronometer = findViewById(R.id.chronometer);
        timePicker1 = findViewById(R.id.timePicker1);
        timePicker2 = findViewById(R.id.timePicker2);
        datePicker1 = findViewById(R.id.datePicker1);
        datePicker2 = findViewById(R.id.datePicker2);
        calendarView = findViewById(R.id.calendarView);
        btn1 = findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Date d = new Date();
                d.setTime(calendarView.getDate());

                String msg = "";
                msg += "clock1 = " + clock1.toString() + "\n";
                msg += "clock2 = " + clock2.getText().toString() + "\n";
                msg += "chronometer = " + chronometer.getText().toString() + "\n";
                msg += "timePicker1 = " + timePicker1.getCurrentHour() + ":" + timePicker1.getCurrentMinute() + "\n";
                msg += "timePicker2 = " + timePicker2.getCurrentHour() + ":" + timePicker2.getCurrentMinute() + "\n";
                msg += "datePicker1 = " + datePicker1.getYear() + "-" + datePicker1.getMonth() + "-" +datePicker1.getDayOfMonth()+ "\n";
                msg += "datePicker2 = " + datePicker2.getYear() + "-" + datePicker2.getMonth() + "-" +datePicker2.getDayOfMonth()+ "\n";
                msg += "calendarView = " + d;
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });

        //Chronometer 중지 & 시작
        chronometer.stop();
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.start();

        // timePicker1 에 시간 설정하기
        timePicker1.setCurrentHour(13);
        timePicker1.setCurrentMinute(35);
        timePicker1.setIs24HourView(true);

        // timePicker2 에 시간 설정하기

        // datePicker1 에 날짜 설정하기
        // java.util.Date
        // jave.util.Calendar
        Calendar c = Calendar.getInstance();
        datePicker1.updateDate(c.get(Calendar.YEAR)-1, c.get(Calendar.MONTH)-1, c.get(Calendar.DATE)-1);

        // datePicker2 에 날짜 설정하기
        datePicker2.updateDate(2000, 3,5);

        // calview 에 시간 설정하기
        Date date = null;
        date = new Date(114, 2, 18); // 1900/01/01 --> 2014/03/18
        calendarView.setDate(date.getTime());
   }
}
