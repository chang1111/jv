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
    private Button add = null;
    private Button minus = null;
    private Button mul = null;
    private Button div = null;
    private Button remainder = null;
    private TextView result = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        add = findViewById(R.id.add);
        minus = findViewById(R.id.minus);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);
        remainder = findViewById(R.id.remainder);
        result = findViewById(R.id.result);

        add.setOnClickListener(new InnerClass());
        minus.setOnClickListener(new InnerClass());
        mul.setOnClickListener(new InnerClass());
        div.setOnClickListener(new InnerClass());
        remainder.setOnClickListener(new InnerClass());
    }

    private class InnerClass implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            try {
                double num1 = Double.valueOf(number1.getText().toString());
                double num2 = Double.valueOf(number2.getText().toString());

                if (view.getId() == add.getId()) {
                    result.setText("계산 결과 : " + (num1 + num2));
                } else if (view.getId() == minus.getId()) {
                    result.setText("계산 결과 : " + (num1 - num2));
                } else if (view.getId() == mul.getId()) {
                    result.setText("계산 결과 : " + (num1 * num2));
                } else if (view.getId() == div.getId()) {
                    if (num2 == 0) {
                        Toast toast = Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다", Toast.LENGTH_SHORT);
                        toast.show();
                    } else {
                        result.setText("계산 결과 : " + (num1 / num2));
                    }
                } else if (view.getId() == remainder.getId()) {
                    if (num2 == 0) {
                        Toast toast = Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다", Toast.LENGTH_SHORT);
                        toast.show();
                    } else {
                        result.setText("계산 결과 : " + (num1 % num2));
                    }
                }
            } catch (Exception e) {
                Toast toast = Toast.makeText(getApplicationContext(), "값을 입력하세요", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }

}
