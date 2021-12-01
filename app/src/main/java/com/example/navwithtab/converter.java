package com.example.navwithtab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class converter extends AppCompatActivity {
    private EditText g;
    TextView setInput;
    RadioButton r1, r2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);
        g = findViewById(R.id.text1);
        setInput = findViewById(R.id.text2);
        r1 = findViewById(R.id.r1);
        r2 = findViewById(R.id.r2);
    }
    public void btn_text1(View view) {


        if(r1.isChecked()){
            String siam1 = g.getText().toString();
            Double value = new Double(siam1);
            Double result = ccConverter.celcious(value);
            setInput.setText(new Double(result).toString());

        }

        else if(r2.isChecked()){
            String siam2 = g.getText().toString();

            Double value = new Double(siam2);
            Double result = farConverter.far(value);
            setInput.setText(new Double(result).toString());
        }


    }
}