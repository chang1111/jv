package com.android.gridcaculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText = null;
    Button list = null;
    Button save = null;
    Button recent = null;
    Button num0 = null;
    Button num1 = null;
    Button num2 = null;
    Button num3 = null;
    Button num4 = null;
    Button num5 = null;
    Button num6 = null;
    Button num7 = null;
    Button num8 = null;
    Button num9 = null;
    Button point = null;
    Button add = null;
    Button sub = null;
    Button mul = null;
    Button div = null;
    Button signed = null;
    Button ac = null;
    Button clear = null;
    Button equal = null;
    Button bracket = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        list = findViewById(R.id.list);
        save = findViewById(R.id.save);
        recent = findViewById(R.id.recent);
        num0 = findViewById(R.id.num0);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        num3 = findViewById(R.id.num3);
        num4 = findViewById(R.id.num4);
        num5 = findViewById(R.id.num5);
        num6 = findViewById(R.id.num6);
        num7 = findViewById(R.id.num7);
        num8 = findViewById(R.id.num8);
        num9 = findViewById(R.id.num9);
        point = findViewById(R.id.point);
        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);
        signed = findViewById(R.id.signed);
        ac = findViewById(R.id.ac);
        clear = findViewById(R.id.clear);
        equal = findViewById(R.id.equal);
        bracket = findViewById(R.id.bracket);

        Input input = new Input();

        list.setOnClickListener(input);
        save.setOnClickListener(input);
        recent.setOnClickListener(input);
        num0.setOnClickListener(input);
        num1.setOnClickListener(input);
        num2.setOnClickListener(input);
        num3.setOnClickListener(input);
        num4.setOnClickListener(input);
        num5.setOnClickListener(input);
        num6.setOnClickListener(input);
        num7.setOnClickListener(input);
        num8.setOnClickListener(input);
        num9.setOnClickListener(input);
        point.setOnClickListener(input);
        add .setOnClickListener(input);
        sub .setOnClickListener(input);
        mul .setOnClickListener(input);
        div .setOnClickListener(input);
        signed.setOnClickListener(input);
        ac.setOnClickListener(input);
        clear.setOnClickListener(input);
        equal.setOnClickListener(input);
        bracket.setOnClickListener(input);
    }

    private class Input implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.list:
                    break;
                case R.id.save:
                    break;
                case R.id.recent:
                    break;
                case R.id.signed:
                    break;
                case R.id.ac:
                    editText.setText("");
                    break;
                case R.id.clear:
                    editText.setText("");
                    break;
                case R.id.equal:
                    Calc calc = new Calc();
                    String infixExp = editText.getText().toString();

                    infixExp = infixExp.replace("\u00D7", "*");
                    infixExp = infixExp.replace("\u00F7", "/");

                    String postfixExp = calc.postfix(infixExp);
                    String result = String.valueOf(calc.result(postfixExp));

                    editText.setText(result);
                    break;
                case R.id.bracket:
                    break;
                default:
                    editText.setText(editText.getText().toString() + ((Button)view).getText().toString());
            }
        }
    }
}
