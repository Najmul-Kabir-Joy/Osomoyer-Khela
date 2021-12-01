package com.example.navwithtab;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.Random;

public class dicecount extends AppCompatActivity {
    Button b_roll, b_even, b_odd, reset;
    EditText input;
    TextView yourvalue, rolledvalue, tv_you, tv_status, winstatus;
    ImageView iv_dice1, iv_dice2;
    int intputInt;
    String inputStr;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dicecount);
        Toolbar toolbar = (Toolbar) findViewById(R.id.custom_toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.mydrawer);
        navigationView = (NavigationView) findViewById(R.id.cnav);

        toggle = new ActionBarDrawerToggle(dicecount.this,drawerLayout,toolbar,R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        b_roll = (Button) findViewById(R.id.b_roll);
        reset = (Button) findViewById(R.id.reset);

        yourvalue = (TextView) findViewById(R.id.tv_yourvalue);
        tv_status = (TextView) findViewById(R.id.tv_status);
        rolledvalue = (TextView) findViewById(R.id.rolled_value);
        winstatus = (TextView) findViewById(R.id.winstatus);

        input = (EditText) findViewById(R.id.input);


        iv_dice1 = (ImageView) findViewById(R.id.iv_dice1);
        iv_dice2 = (ImageView) findViewById(R.id.iv_dice2);

        b_roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputStr = input.getText().toString();
                intputInt = Integer.parseInt(inputStr);
                if (inputStr.equals(null) || inputStr.equals("")){
                    Toast.makeText(getApplicationContext(),"Please give input",Toast.LENGTH_SHORT).show();
                }
                else if (intputInt>0 && intputInt<13){
                    yourvalue.setText("Your Value: " +String.valueOf(intputInt));
                    Random random = new Random();
                    int firstdice = random.nextInt(6) +1;
                    int seconddice = random.nextInt(6) +1;
                    setImage(firstdice, seconddice);
                    int sum = firstdice + seconddice;

                    rolledvalue.setText("Rolled Value: " +String.valueOf(sum));
                    if (intputInt == sum){
                        winstatus.setTextColor(Color.parseColor("#00b33c"));
                        winstatus.setText("Hurray! Perfect Guess");
                        Toast.makeText(getApplicationContext(),"Hurray! Perfect Guess",Toast.LENGTH_SHORT).show();
                    }else{
                        winstatus.setTextColor(Color.parseColor("#ff5c33"));
                        winstatus.setText("Sadly Sorry, Wrong Guess");
                        Toast.makeText(getApplicationContext(),"Sadly Sorry, Wrong Guess",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(getApplicationContext(),"Please input between 1-12",Toast.LENGTH_SHORT).show();

                }

                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
                iv_dice1.startAnimation(animation);
                iv_dice2.startAnimation(animation);





            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //currentPick = "odd";
                //tv_status.setText(currentPick);
                winstatus.setText("");
                yourvalue.setText("Your Value: 0");
                rolledvalue.setText("Rolled Value: 0");
                input.setText("");


            }
        });
    }
    private void setImage(int dice1number, int dice2number){
        switch (dice1number){
            case 1:
                iv_dice1.setImageResource(R.drawable.dice1);
                break;
            case 2:
                iv_dice1.setImageResource(R.drawable.dice2);
                break;
            case 3:
                iv_dice1.setImageResource(R.drawable.dice3);
                break;
            case 4:
                iv_dice1.setImageResource(R.drawable.dice4);
                break;
            case 5:
                iv_dice1.setImageResource(R.drawable.dice5);
                break;
            case 6:
                iv_dice1.setImageResource(R.drawable.dice6);
                break;

        }

        switch (dice2number){
            case 1:
                iv_dice2.setImageResource(R.drawable.dice1);
                break;
            case 2:
                iv_dice2.setImageResource(R.drawable.dice2);
                break;
            case 3:
                iv_dice2.setImageResource(R.drawable.dice3);
                break;
            case 4:
                iv_dice2.setImageResource(R.drawable.dice4);
                break;
            case 5:
                iv_dice2.setImageResource(R.drawable.dice5);
                break;
            case 6:
                iv_dice2.setImageResource(R.drawable.dice6);
                break;

        }

    }

}