package com.example.navwithtab;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import java.util.Random;

public class roulette extends AppCompatActivity {
    Button button;
    TextView textView;
    ImageView iv_wheel;
    int degree = 0, degreeold = 0;
    private static final float Factor = 4.72f;


    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roulette);

        Toolbar toolbar = (Toolbar) findViewById(R.id.custom_toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.mydrawer);
        navigationView = (NavigationView) findViewById(R.id.cnav);

        toggle = new ActionBarDrawerToggle(roulette.this,drawerLayout,toolbar,R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        button = (Button) findViewById(R.id.spin_btn);
        textView = (TextView) findViewById(R.id.tv);
        iv_wheel = (ImageView) findViewById(R.id.wheel);

        final Random random = new Random();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                degree = random.nextInt(3600) + 720;
                degreeold = degree % 360;
                RotateAnimation rotate = new RotateAnimation(degreeold, degree, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                rotate.setDuration(3600);
                rotate.setFillAfter(true);
                rotate.setInterpolator(new DecelerateInterpolator());
                rotate.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        textView.setText("");

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        textView.setText(currentNumber(360 - (degree % 360)));

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                iv_wheel.startAnimation(rotate);


            }
        });
    }
    private String currentNumber(int degress){
        String text = "";
        if (degress >= (Factor * 1) && degress < (Factor * 3)){
            text = "27 RED";
        }
        if (degress >= (Factor * 3) && degress < (Factor * 5)){
            text = "10 BLACK";
        }

        if (degress >= (Factor * 5) && degress < (Factor * 7)){
            text = "35 RED";
        }
        if (degress >= (Factor * 7) && degress < (Factor * 9)){
            text = "29 BLACK";
        }
        if (degress >= (Factor * 9) && degress < (Factor * 11)){
            text = "12 RED";
        }
        if (degress >= (Factor * 11) && degress < (Factor * 13)){
            text = "8 BLACK";
        }
        if (degress >= (Factor * 13) && degress < (Factor * 15)){
            text = "19 RED";
        }
        if (degress >= (Factor * 15) && degress < (Factor * 17)){
            text = "31 BLACK";
        }
        if (degress >= (Factor * 17) && degress < (Factor * 19)){
            text = "18 RED";
        }
        if (degress >= (Factor * 19) && degress < (Factor * 21)){
            text = "6 BLACK";
        }
        if (degress >= (Factor * 21) && degress < (Factor * 23)){
            text = "21 RED";
        }
        if (degress >= (Factor * 23) && degress < (Factor * 25)){
            text = "33 BLACK";
        }
        if (degress >= (Factor * 25) && degress < (Factor * 27)){
            text = "16 RED";
        }
        if (degress >= (Factor * 27) && degress < (Factor * 29)){
            text = "4 BLACK";
        }
        if (degress >= (Factor * 29) && degress < (Factor * 31)){
            text = "23 RED";
        }
        if (degress >= (Factor * 31) && degress < (Factor * 33)){
            text = "35 BLACK";
        }
        if (degress >= (Factor * 33) && degress < (Factor * 35)){
            text = "14 RED";
        }
        if (degress >= (Factor * 35) && degress < (Factor * 37)){
            text = "2 BLACK";
        }
        if (degress >= (Factor * 37) && degress < (Factor * 39)){
            text = "0";
        }
        if (degress >= (Factor * 39) && degress < (Factor * 41)){
            text = "28 BLACK";
        }
        if (degress >= (Factor * 41) && degress < (Factor * 43)){
            text = "9 RED";
        }
        if (degress >= (Factor * 43) && degress < (Factor * 45)){
            text = "26 BLACK";
        }
        if (degress >= (Factor * 45) && degress < (Factor * 47)){
            text = "30 RED";
        }
        if (degress >= (Factor * 47) && degress < (Factor * 49)){
            text = "11 BLACK";
        }
        if (degress >= (Factor * 49) && degress < (Factor * 51)){
            text = "7 RED";
        }
        if (degress >= (Factor * 51) && degress < (Factor * 53)){
            text = "20 BLACK";
        }
        if (degress >= (Factor * 53) && degress < (Factor * 55)){
            text = "32 RED";
        }
        if (degress >= (Factor * 55) && degress < (Factor * 57)){
            text = "17 BLACK";
        }
        if (degress >= (Factor * 57) && degress < (Factor * 59)){
            text = "5 RED";
        }
        if (degress >= (Factor * 59) && degress < (Factor * 61)){
            text = "22 BLACK";
        }
        if (degress >= (Factor * 61) && degress < (Factor * 63)){
            text = "34 RED";
        }
        if (degress >= (Factor * 63) && degress < (Factor * 65)){
            text = "15 BLACK";
        }
        if (degress >= (Factor * 65) && degress < (Factor * 67)){
            text = "3 RED";
        }
        if (degress >= (Factor * 67) && degress < (Factor * 69)){
            text = "24 BLACK";
        }
        if (degress >= (Factor * 69) && degress < (Factor * 71)){
            text = "36 RED";
        }
        if (degress >= (Factor * 71) && degress < (Factor * 73)){
            text = "13 BLACK";
        }
        if (degress >= (Factor * 73) && degress < (Factor * 75)){
            text = "1 RED";
        }
        if ((degress >= (Factor * 73) && degress < 360) || (degress>= 0 && degress < (Factor*1))){
            text = "00";
        }


        return text;
    }
}