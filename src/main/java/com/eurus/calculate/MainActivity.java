package com.eurus.calculate;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import parsii.eval.Parser;

public class MainActivity extends Activity implements View.OnClickListener {
    private Button btn_0;
    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_4;
    private Button btn_5;
    private Button btn_6;
    private Button btn_7;
    private Button btn_8;
    private Button btn_9;
    private Button btn_point;
    private Button btn_clear;
    private Button btn_del;
    private Button btn_plus;
    private Button btn_minus;
    private Button btn_multiply;
    private Button btn_divide;
    private Button btn_equal;
    private Button btn_leftbracket;
    private Button btn_rightbracket;
    private EditText text;
    private boolean needClean = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //实例化按钮
        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_9 = (Button) findViewById(R.id.btn_9);
        btn_clear = (Button) findViewById(R.id.btn_clear);
        btn_del = (Button) findViewById(R.id.btn_del);
        btn_point = (Button) findViewById(R.id.btn_point);
        btn_plus = (Button) findViewById(R.id.btn_plus);
        btn_minus = (Button) findViewById(R.id.btn_minus);
        btn_multiply = (Button) findViewById(R.id.btn_multiply);
        btn_divide = (Button) findViewById(R.id.btn_divide);
        btn_equal = (Button) findViewById(R.id.btn_equal);
        btn_leftbracket = (Button) findViewById(R.id.btn_leftbracket);
        btn_rightbracket = (Button) findViewById(R.id.btn_rightbracket);
        text = (EditText) findViewById(R.id.text);

        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_point.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_multiply.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_leftbracket.setOnClickListener(this);
        btn_rightbracket.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String str="";
        if(this.needClean==true){
            text.setText("");
            this.needClean=false;
        }else{
             str =  text.getText().toString();
        }
        switch (v.getId()) {
            case R.id.btn_0:
            case R.id.btn_1:
            case R.id.btn_2:
            case R.id.btn_3:
            case R.id.btn_4:
            case R.id.btn_5:
            case R.id.btn_6:
            case R.id.btn_7:
            case R.id.btn_8:
            case R.id.btn_9:
            case R.id.btn_leftbracket:
            case R.id.btn_rightbracket:
            case R.id.btn_point:
                text.setText(str + ((Button) v).getText());
                break;
            case R.id.btn_plus:
            case R.id.btn_minus:
            case R.id.btn_multiply:
            case R.id.btn_divide:
                text.setText(str + ((Button) v).getText());
                break;
            case R.id.btn_clear:
                text.setText("");
                break;
            case R.id.btn_del:
                if(text.length()>0) {
                    text.setText(str.substring(0, str.length() - 1));
                }
                break;
            case R.id.btn_equal:
                String answer = calculate(str);
                text.setText(str+"=\n"+answer);
                break;
        }

    }

    private String calculate(String str) {
        this.needClean =true;
        //将给出的字符串计算结果之后再返回字符串
        try {
            str = str.replaceAll("÷","/");
            str = str.replaceAll("×","*");
            parsii.eval.Expression parsiiExpr = Parser.parse(str);
            double result = parsiiExpr.evaluate();
            return String.valueOf(result);
        } catch (Exception e) {
            return "非法输入哦 = =！";
        }
    }
}
