package com.android.simplecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText number1 = null;
    private EditText number2 = null;
    private Button BtnAdd = null;
    private Button BtnSub = null;
    private Button BtnMul = null;
    private Button BtnDiv = null;
    private Button BtnRem = null;
    private TextView TextResult = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        BtnAdd = findViewById(R.id.BtnAdd);
        BtnSub = findViewById(R.id.BtnSub);
        BtnMul = findViewById(R.id.BtnMul);
        BtnDiv = findViewById(R.id.BtnDiv);
        BtnRem = findViewById(R.id.BtnRem);
        TextResult = findViewById(R.id.TextResult);

        HandlerClass handler = new HandlerClass();

        BtnAdd.setOnClickListener(handler);
        BtnSub.setOnClickListener(handler);
        BtnMul.setOnClickListener(handler);
        BtnDiv.setOnClickListener(handler);
        BtnRem.setOnClickListener(handler);
    }

    private class HandlerClass implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            try {
                double num1 = Double.valueOf(number1.getText().toString());
                double num2 = Double.valueOf(number2.getText().toString());
                double result = 0;

                switch (view.getId()) {
                    case R.id.BtnAdd:
                        result = num1 + num2;
                        TextResult.setText("계산 결과 : " + String.format("%.6f", result));
                        break;
                    case R.id.BtnSub:
                        result = num1 - num2;
                        TextResult.setText("계산 결과 : " + String.format("%.6f", result));
                        break;
                    case R.id.BtnMul:
                        result = num1 * num2;
                        TextResult.setText("계산 결과 : " + String.format("%.6f", result));
                        break;
                    case R.id.BtnDiv:
                        if (num2 == 0) {
                            Toast toast = Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다", Toast.LENGTH_SHORT);
                            toast.show();
                        } else {
                            result = num1 / num2;
                            TextResult.setText("계산 결과 : " + String.format("%.6f", result));
                        }
                        break;
                    case R.id.BtnRem:
                        if (num2 == 0) {
                            Toast toast = Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다", Toast.LENGTH_SHORT);
                            toast.show();
                        } else {
                            result = num1 % num2;
                            TextResult.setText("계산 결과 : " + String.format("%.6f", result));
                        }
                        break;
                }
            } catch (Exception e) {
                Toast toast = Toast.makeText(getApplicationContext(), "숫자를 입력하세요", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }

}
