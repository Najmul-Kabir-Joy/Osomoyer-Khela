package com.example.navwithtab;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.Random;

public class calculation extends AppCompatActivity {

    TextView tv_point, tv_result, tv_num1, tv_num2;
    Button check,reset_btn,que_btn;
    EditText input;
    Integer point = 0,r1=0,r2=0,sum=0;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.custom_toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.mydrawer);
        navigationView = (NavigationView) findViewById(R.id.cnav);

        toggle = new ActionBarDrawerToggle(calculation.this,drawerLayout,toolbar,R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        tv_point = (TextView) findViewById(R.id.tv_point);
        tv_result = (TextView) findViewById(R.id.tv_result);
        tv_num1 = (TextView) findViewById(R.id.tv_num1);
        tv_num2 = (TextView) findViewById(R.id.tv_num2);

        input = (EditText) findViewById(R.id.input);

        check = (Button) findViewById(R.id.check_btn);
       // que_btn = (Button) findViewById(R.id.newquestion);

        reset_btn = (Button) findViewById(R.id.reset_btn);
        setter();


        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input_string = input.getText().toString();
                Integer input_integer = Integer.parseInt(input_string);
                sum = r1+r2;
                try {
                    if (input_integer.equals(sum)){
                        tv_result.setText("Perfect! Go Next.");
                        point+=2;
                        tv_point.setText("Point "+point);
                    }else {
                        tv_result.setText("Wrong!!"+input_integer);
                        point -=4;
                        tv_point.setText("Point: "+point);
                    }
                }catch (Exception e){
                    Toast.makeText(calculation.this, "No Input found", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(calculation.this,calculation.class);
                }
                setter();

            }
        });
//
//        que_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setter();
//                r1=0;
//                r2=0;
//            }
//        });

        reset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_point.setText("Point: 0");
                r1=0;
                r2=0;
                point=0;
                sum=0;
                setter();
            }
        });
    }
    private void setter(){
        Random random = new Random();
        r1 = random.nextInt(400)+1;
        r2 = random.nextInt(400)+1;
        tv_num1.setText(""+r1);
        tv_num2.setText(""+r2);
        input.setText("");


    }
}