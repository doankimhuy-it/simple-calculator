package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;
    private Button b7;
    private Button b8;
    private Button b9;
    private Button b0;
    private Button bEqual;
    private Button bAdd;
    private Button bSub;
    private Button bMulti;
    private Button bDiv;
    private Button bClear;
    private Button bBKSP;
    private Button bSign;
    private TextView textView;
    private int op1 = Integer.MIN_VALUE;
    private int op2 = Integer.MIN_VALUE;
    private String operator = "";
    private int res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        assignVariables();

        b1.setOnClickListener(btnNumListener);

        b2.setOnClickListener(btnNumListener);

        b3.setOnClickListener(btnNumListener);

        b4.setOnClickListener(btnNumListener);

        b5.setOnClickListener(btnNumListener);

        b6.setOnClickListener(btnNumListener);

        b7.setOnClickListener(btnNumListener);

        b8.setOnClickListener(btnNumListener);

        b9.setOnClickListener(btnNumListener);

        b0.setOnClickListener(btnNumListener);

        bAdd.setOnClickListener(btnOprListener);

        bSub.setOnClickListener(btnOprListener);

        bMulti.setOnClickListener(btnOprListener);

        bDiv.setOnClickListener(btnOprListener);

        bBKSP.setOnClickListener(view -> {
            String text = textView.getText().toString();
            int length = textView.length();
            if (length > 0) {
                textView.setText(text.substring(0, length - 1));
            }
        });

        bSign.setOnClickListener(view -> {
            if (!textView.getText().toString().equals("")) {
                int tmp = Integer.parseInt(textView.getText().toString(), 10);
                tmp = -tmp;
                textView.setText(String.format("%s", tmp));
                if (op1 == Integer.MIN_VALUE) {
                    op1 = tmp;
                } else if (op2 == Integer.MIN_VALUE) {
                    op2 = tmp;
                }
            }
        });

        bEqual.setOnClickListener(view -> {
            op2 = Integer.parseInt(textView.getText().toString(), 10);
            if (op2 != Integer.MIN_VALUE) {
                switch (operator) {
                    case "+":
                        res = op1 + op2;
                        textView.setText(String.valueOf(res));
                        break;
                    case "-":
                        res = op1 - op2;
                        textView.setText(String.valueOf(res));
                        break;
                    case "*":
                        res = op1 * op2;
                        textView.setText(String.valueOf(res));
                        break;
                    case "/":
                        if (op2 == 0) {
                            textView.setText(R.string.err);
                        } else {
                            res = op1 / op2;
                            textView.setText(String.valueOf(res));
                        }
                }
            }
        });

        bClear.setOnClickListener(view -> {
            op1 = Integer.MIN_VALUE;
            op2 = Integer.MIN_VALUE;
            textView.setText("");
        });
    }

    View.OnClickListener btnNumListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button btn = (Button) view;
            textView.setText(String.format("%s%s", textView.getText().toString(), btn.getText().toString()));
        }
    };

    View.OnClickListener btnOprListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button btn = (Button) view;
            op1 = Integer.parseInt(textView.getText().toString(), 10);
            operator = btn.getText().toString();
            textView.setText("");
        }
    };

    private void assignVariables() {
        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        b6 = findViewById(R.id.button6);
        b7 = findViewById(R.id.button7);
        b8 = findViewById(R.id.button8);
        b9 = findViewById(R.id.button9);
        b0 = findViewById(R.id.button0);
        bAdd = findViewById(R.id.buttonAdd);
        bSub = findViewById(R.id.buttonSub);
        bMulti = findViewById(R.id.buttonMulti);
        bDiv = findViewById(R.id.buttonDivide);
        bEqual = findViewById(R.id.buttonEqual);
        bClear = findViewById(R.id.buttonClear);
        bBKSP = findViewById(R.id.buttonBKSP);
        bSign = findViewById(R.id.buttonSign);
        textView = findViewById(R.id.textViewNumber);
    }
}