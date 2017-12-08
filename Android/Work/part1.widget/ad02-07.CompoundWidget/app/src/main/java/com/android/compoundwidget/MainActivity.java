package com.android.compoundwidget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rgpDirection = null;
    private RadioGroup rgpGravity = null;
    private RadioButton radioHorizen = null;
    private RadioButton radioVertical = null;
    private RadioButton radioLeft = null;
    private RadioButton radioCenter = null;
    private RadioButton radioRight = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgpDirection = findViewById(R.id.rgpDirection);
        rgpGravity = findViewById(R.id.rgpGravity);
        radioHorizen = findViewById(R.id.radioHorizen);
        radioVertical = findViewById(R.id.radioVertical);
        radioLeft = findViewById(R.id.radioLeft);
        radioCenter = findViewById(R.id.radioCenter);
        radioRight = findViewById(R.id.radioRight);

        rgpDirection.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.radioHorizen) {
                    rgpDirection.setOrientation(LinearLayout.HORIZONTAL);
                }
                else if (i == R.id.radioVertical) {
                    rgpDirection.setOrientation(LinearLayout.VERTICAL);
                }
            }
        });

        rgpGravity.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.radioLeft) {
                    rgpGravity.setGravity(Gravity.LEFT);
                }
                else if (i == R.id.radioCenter) {
                    rgpGravity.setGravity(Gravity.CENTER);
                }
                else if (i == R.id.radioRight) {
                    rgpGravity.setGravity(Gravity.RIGHT);
                }
            }
        });

//        HandlerClass handler = new HandlerClass();
//        radioHorizen.setOnClickListener(handler);
//        radioVertical.setOnClickListener(handler);
//        radioLeft.setOnClickListener(handler);
//        radioCenter.setOnClickListener(handler);
//        radioRight.setOnClickListener(handler);

    }

//    private class HandlerClass implements View.OnClickListener {
//
//        @Override
//        public void onClick(View view) {
//            int id = view.getId();
//
//            switch (id) {
//                case R.id.radioHorizen:
//                    rgpDirection.setOrientation(LinearLayout.HORIZONTAL);
//                    break;
//                case R.id.radioVertical:
//                    rgpDirection.setOrientation(LinearLayout.VERTICAL);
//                    break;
//                case R.id.radioLeft:
//                    rgpGravity.setGravity(Gravity.LEFT);
//                    break;
//                case R.id.radioCenter:
//                    rgpGravity.setGravity(Gravity.CENTER);
//                    break;
//                case R.id.radioRight:
//                    rgpGravity.setGravity(Gravity.RIGHT);
//                    break;
//            }
//
//        }
//    }
}
