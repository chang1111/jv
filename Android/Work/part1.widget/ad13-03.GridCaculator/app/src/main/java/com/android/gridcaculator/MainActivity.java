package com.android.gridcaculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

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
    Calc calc = null;
    List<String> resultList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calc = new Calc();
        resultList = new ArrayList<String>();
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

    public boolean checkNumberLength() {
        // 텍스트 필드의 마지막 연산자 찾기
        String text = editText.getText().toString();
        String[] operators = {"+", "-", "\u00D7", "\u00F7"};
        int posLastOper = calc.getLastIndex(editText.getText().toString(), operators);

        // 현재 텍스트 필드의 길이 구하기
        int textLength = editText.getText().toString().length();

        if (textLength - posLastOper > 17) {
            // 경고창 띄운다
            Toast toast = Toast.makeText(getApplicationContext(), "17자 이상 입력 불가", Toast.LENGTH_SHORT);
            toast.show();
            return false;
        }
        else {
            return true;
        }
    }

    private class Input implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            String text = null;
            switch (view.getId()) {
                case R.id.list:
                    for (int i = 0;i <resultList.size();i++) {
                        if (i == 0) {
                            editText.setText(resultList.get(i));
                        }
                        else {
                            editText.setText(editText.getText().toString() + "\n" + resultList.get(i));
                        }
                    }
                    break;
                case R.id.save:
                    text = editText.getText().toString();
                    if (!text.isEmpty()) {
                        resultList.add(0, editText.getText().toString());
                        if (resultList.size() > 3) {
                            resultList.remove(resultList.size() - 1);
                        }
                    }
                    break;
                case R.id.recent:
                    editText.setText(resultList.get(0));
                    break;
                case R.id.add:
                case R.id.sub:
                case R.id.mul:
                case R.id.div:
                    text = editText.getText().toString();
                    if (!text.isEmpty()) {
                        String last_text = text.substring(text.length() - 1);
                        if (!(last_text.equals("+") || last_text.equals("-") || last_text.equals("\u00D7") || last_text.equals("\u00F7"))) {
                            if (!(last_text.equals(".")||last_text.equals("("))) {
                                editText.setText(text + ((Button) view).getText().toString());
                            }
                        }
                        else {
                            editText.setText(text.substring(0, text.length() - 1) + ((Button) view).getText().toString());
                        }
                    }
                    break;
                case R.id.point:
                    text = editText.getText().toString();
                    if (text.isEmpty()) {
                        editText.setText(".");
                    }
                    else {
                        String last_text = text.substring(text.length() - 1);
                        if (!last_text.equals(")")) {
                            String[] operators = {"+", "-", "\u00D7", "\u00F7"};
                            int posLastOper = calc.getLastIndex(text, operators);
                            if (!text.substring(posLastOper).contains(".")) {
                                editText.setText(text + ".");
                            }
                        }
                    }
                    break;
                case R.id.signed:
                    break;
                case R.id.ac:
                    editText.setText("");
                    break;
                case R.id.clear:
                    text = editText.getText().toString();
                    if (!text.isEmpty()) {
                        editText.setText(text.substring(0, text.length() - 1));
                    }
                    break;
                case R.id.equal:
                    String infixExp = editText.getText().toString();

                    int left = 0;
                    int right = 0;
                    for (int i = 0; i < infixExp.length(); i++) {
                        if (infixExp.charAt(i) == '(') {
                            left++;
                        }
                        if (infixExp.charAt(i) == ')') {
                            right++;
                        }
                    }
                    if (left == right) {
                        resultList.add(0, infixExp);
                        infixExp = infixExp.replace("\u00D7", "*");
                        infixExp = infixExp.replace("\u00F7", "/");

                        try {
                            String postfixExp = calc.postfix(infixExp);
                            String result = String.valueOf(calc.result(postfixExp));
                            if (resultList.size() > 3) {
                                resultList.remove(resultList.size() - 1);
                            }
                            editText.setText(result);
                        }
                        catch (Exception e) {
                            resultList.remove(0);
                        }
                    }
                    break;
                case R.id.bracket:
                    text = editText.getText().toString();
                    if (text.isEmpty()) {
                        editText.setText("(");
                    }
                    else {
                        String last_text = text.substring(text.length() - 1);
                        if (!(last_text.equals("."))) {
                            if (last_text.equals("+")||last_text.equals("-")||last_text.equals("\u00D7")||last_text.equals("\u00F7")||last_text.equals("(")) {
                                editText.setText(editText.getText().toString() + "(");
                            }
                            else {
                                int count_l = 0;
                                int count_r = 0;
                                for (int i = 0; i < text.length(); i++) {
                                    if (text.charAt(i) == '(') {
                                        count_l++;
                                    }
                                    if (text.charAt(i) == ')') {
                                        count_r++;
                                    }
                                }
                                if (count_l > count_r) {
                                    editText.setText(editText.getText().toString() + ")");
                                }
                            }
                        }
                    }
                    break;
                default:
                    text = editText.getText().toString();
                    String input = ((Button) view).getText().toString();
                    if (text.isEmpty()) {
                        editText.setText(editText.getText().toString() + input);
                    }
                    else {
                        String last_text = text.substring(text.length() - 1);
                        if (!last_text.equals(")")) {
                            if (checkNumberLength()) {
                                editText.setText(editText.getText().toString() + input);
                            }
                        }
                    }
            }
        }
    }
}
