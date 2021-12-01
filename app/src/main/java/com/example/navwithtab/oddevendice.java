package com.example.navwithtab;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import java.util.Random;

public class oddevendice extends AppCompatActivity {
    Button b_roll, b_even, b_odd, reset;
    TextView tv_cpu, tv_you, tv_status;
    ImageView iv_dice1, iv_dice2;
    int cpuPoints = 0 , youPoints = 0;
    String currentPick = "";

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_oddevendice);
        b_roll = (Button) findViewById(R.id.b_roll);
        b_even = (Button) findViewById(R.id.b_even);
        b_odd = (Button) findViewById(R.id.b_odd);
        reset = (Button) findViewById(R.id.reset);

        tv_cpu = (TextView) findViewById(R.id.tv_cpu);
        tv_you = (TextView) findViewById(R.id.tv_you);
        tv_status = (TextView) findViewById(R.id.tv_status);

        iv_dice1 = (ImageView) findViewById(R.id.iv_dice1);
        iv_dice2 = (ImageView) findViewById(R.id.iv_dice2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.custom_toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.mydrawer);
        navigationView = (NavigationView) findViewById(R.id.cnav);
        toggle = new ActionBarDrawerToggle(oddevendice.this,drawerLayout,toolbar,R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        b_roll.setVisibility(View.INVISIBLE);

        b_roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int firstdice = random.nextInt(6) + 1;
                int seconddice = random.nextInt(6) + 1;

                setImage(firstdice, seconddice);

                int sum = firstdice + seconddice;




                int left = sum %2;

                if (currentPick.equals("EVEN")){
                    if(left == 0){
                        youPoints++;
                    }
                    if(left != 0){
                        cpuPoints++;
                    }

                }
                if (currentPick.equals("ODD")){
                    if(left == 0){
                        cpuPoints++;
                    }
                    if(left != 0){
                        youPoints++;
                    }

                }
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
                iv_dice1.startAnimation(animation);
                iv_dice2.startAnimation(animation);

                tv_cpu.setText("CPU: " +cpuPoints);
                tv_you.setText("You: " +youPoints);

                b_roll.setVisibility(View.INVISIBLE);
                b_even.setVisibility(View.VISIBLE);
                b_odd.setVisibility(View.VISIBLE);



            }
        });
        b_even.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPick = "EVEN";

                b_roll.setVisibility(View.VISIBLE);
                b_even.setVisibility(View.INVISIBLE);
                b_odd.setVisibility(View.INVISIBLE);
                tv_status.setText(currentPick);


            }
        });
        b_odd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPick = "ODD";
                tv_status.setText(currentPick);

                b_roll.setVisibility(View.VISIBLE);
                b_even.setVisibility(View.INVISIBLE);
                b_odd.setVisibility(View.INVISIBLE);


            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //currentPick = "odd";
                //tv_status.setText(currentPick);
                cpuPoints=0;
                youPoints=0;
                tv_cpu.setText("CPU: " +cpuPoints);
                tv_you.setText("You: " +youPoints);

                // b_roll.setVisibility(View.VISIBLE);
                // b_even.setVisibility(View.INVISIBLE);
                // b_odd.setVisibility(View.INVISIBLE);


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