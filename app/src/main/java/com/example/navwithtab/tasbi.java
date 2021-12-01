package com.example.navwithtab;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class tasbi extends AppCompatActivity {
    Button b1,b2,b3,b4,b5;
    TextView t1,t2,t3,t4,t5;

    int countsbn = 0, countalhmmd=0, countallahu=0,countlaila= 0,total =0;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasbi);
        b1 = findViewById(R.id.sbn);
        b2 = findViewById(R.id.alhmd);
        b3 = findViewById(R.id.alhu);
        b4 = findViewById(R.id.laila);
        b5 = findViewById(R.id.res);
        t1 = findViewById(R.id.tv_total);
        t2 = findViewById(R.id.tv_sbn);
        t3 = findViewById(R.id.tv_alhmd);
        t4 = findViewById(R.id.tv_Allahu);
        t5 = findViewById(R.id.tv_laila);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countsbn++;
                t2.setText("সুবাহান আল্লাহ্: "+countsbn);
                total = countsbn+countalhmmd+countallahu+countlaila;
                t1.setText("সর্বমোট: "+total);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countalhmmd++;
                t3.setText("আলহামদুলিল্লাহ্: "+countalhmmd);
                total = countsbn+countalhmmd+countallahu+countlaila;
                t1.setText("সর্বমোট: "+total);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countallahu++;
                t4.setText("আল্লাহু আকবার: "+countallahu);
                total = countsbn+countalhmmd+countallahu+countlaila;
                t1.setText("সর্বমোট: "+total);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countlaila++;
                t5.setText("লা-ইলাহা ইল্লা-আল্লাহ্: "+countlaila);
                total = countsbn+countalhmmd+countallahu+countlaila;
                t1.setText("সর্বমোট: "+total);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText("সর্বমোট: ০০");
                t2.setText("সুবাহান আল্লাহ্: ০০");
                t3.setText("আলহামদুলিল্লাহ্: ০০");
                t4.setText("আল্লাহু আকবার: ০০");
                t5.setText("লা-ইলাহা ইল্লা-আল্লাহ্: ০০");
                total = 0;
                countsbn=0;
                countlaila = 0;
                countallahu = 0;
                countalhmmd =0;
            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.custom_toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.mydrawer);
        navigationView = (NavigationView) findViewById(R.id.cnav);


        toggle = new ActionBarDrawerToggle(tasbi.this,drawerLayout,toolbar,R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


    }
}