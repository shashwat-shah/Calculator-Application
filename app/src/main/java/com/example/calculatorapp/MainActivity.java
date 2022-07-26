package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_0;
    ImageView btn_dot, btn_equal, btn_ac, btn_modulo, btn_plus, btn_minus, btn_multiplication, btn_extra;
    TextView inputText, outputText;
    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outputText = findViewById(R.id.outputText);
        inputText = findViewById(R.id.inputText);

        btn_0 = findViewById(R.id.btn_0);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);

        btn_dot = findViewById(R.id.btn_dot);
        btn_equal = findViewById(R.id.btn_equal);
        btn_ac = findViewById(R.id.btn_ac);
        btn_modulo = findViewById(R.id.btn_modulo);
        btn_plus = findViewById(R.id.btn_plus);
        btn_minus = findViewById(R.id.btn_minus);
        btn_multiplication = findViewById(R.id.btn_multiplication);
        btn_extra=findViewById(R.id.btn_extra);

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data + "0");
            }
        });

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data + "1");
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data + "2");
            }
        });


        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data + "3");
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data + "4");
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data + "5");
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data + "6");
            }
        });

        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data + "7");
            }
        });

        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data + "8");
            }
        });

        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data + "9");
            }
        });




        btn_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText("");
                outputText.setText("");
            }
        });

        btn_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data + ".");
            }
        });

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data + "+");
            }
        });

        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data + "-");
            }
        });

        btn_modulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data + "%");
            }
        });

        btn_multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data + "×");
            }
        });

        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inputText.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Enter Some Values To Calculate!", Toast.LENGTH_SHORT).show();
                }
                else {
                    data = inputText.getText().toString();

                    data = data.replaceAll("×", "*");
                    data = data.replaceAll("%", "/100");
                    data = data.replaceAll("÷", "/");

                    Context rhino = Context.enter();
                    rhino.setOptimizationLevel(-1);

                    String finalAnswer = "";

                    Scriptable scriptable = rhino.initStandardObjects();
                    finalAnswer = rhino.evaluateString(scriptable, data, "Javsscript", 1, null).toString();

                    outputText.setText(finalAnswer);
                }
            }
        });

    }

    public void backSpace(View view) {
        String input =inputText.getText().toString();
        
        if (input.length()>0)
        {
            inputText.setText(input.substring(0,input.length()-1));
        }
        else if (input.isEmpty()){
            Toast.makeText(this, "Nothing to Delete", Toast.LENGTH_SHORT).show();
        }
    }
}