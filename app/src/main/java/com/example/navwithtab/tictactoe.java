package com.example.navwithtab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class tictactoe extends AppCompatActivity implements View.OnClickListener{
    private TextView playeronescore, playertwoscore, playerstatus;
    private Button[] buttons = new Button[9];
    private Button resestgame;

    private int playeronescorecount, playertwoscorecount, rountcount;
    boolean activeplayer;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    //p1 => 0
    //p2 => 1
    //empty
    int [] gamestate = {2,2,2,2,2,2,2,2,2};

    int [][] winnningpositions = {
            {0,1,2}, {3,4,5}, {6,7,8},
            {0,3,6}, {1,4,7}, {2,5,8},
            {0,4,8}, {2,4,6}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tictactoe);
        playeronescore = (TextView) findViewById(R.id.playeronescore);
        playertwoscore = (TextView) findViewById(R.id.playertwoscore);

        playerstatus = (TextView) findViewById(R.id.playerstatus);

        resestgame = (Button) findViewById(R.id.resetgame);

        for (int i=0; i < buttons.length; i++){
            String buttonid = "btn_" + i;
            int resourceid = getResources().getIdentifier(buttonid,"id",getPackageName());
            buttons[i] = (Button) findViewById(resourceid);

            buttons[i].setOnClickListener(this);
        }

        rountcount = 0;
        playeronescorecount = 0;
        playertwoscorecount =  0;
        activeplayer = true;



        Toolbar toolbar = (Toolbar) findViewById(R.id.custom_toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.mydrawer);
        navigationView = (NavigationView) findViewById(R.id.cnav);


        toggle = new ActionBarDrawerToggle(tictactoe.this,drawerLayout,toolbar,R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();



        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        Intent intent = new Intent(tictactoe.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                }
                return false;
            }
        });

    }


    @Override
    public void onClick(View v) {

        if (!((Button)v).getText().toString().equals("")){
            return;
        }

        String buttonid = v.getResources().getResourceEntryName(v.getId());
        int gamestatepointer = Integer.parseInt(buttonid.substring(buttonid.length()-1,buttonid.length()));

        if (activeplayer){
            ((Button)v).setText("X");
            ((Button)v).setTextColor(Color.parseColor("#FF3333"));
            gamestate[gamestatepointer] = 0;

        }else {
            ((Button)v).setText("O");
            ((Button)v).setTextColor(Color.parseColor("#00CC00"));
            gamestate[gamestatepointer] = 1;
        }
        rountcount++;
        if (checkwinner()){
            if (activeplayer){
                playeronescorecount++;
                updateplayerscore();
                Toast.makeText(this,"Player one won!", Toast.LENGTH_SHORT).show();
                playagain();
            }else {
                playertwoscorecount++;
                updateplayerscore();
                Toast.makeText(this,"Player two won!", Toast.LENGTH_SHORT).show();
                playagain();

            }

        }else if(rountcount == 9){
            playagain();
            Toast.makeText(this, "No Winner!", Toast.LENGTH_SHORT).show();

        }else {
            activeplayer = !activeplayer;
        }

        if(playeronescorecount > playertwoscorecount){
            playerstatus.setText("Player one is winning!");
        }else if (playertwoscorecount > playeronescorecount){
            playerstatus.setText("Player two is winning!");
        }else {
            playerstatus.setText("");
        }

        resestgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playagain();
                playeronescorecount= 0;
                playertwoscorecount = 0;
                playerstatus.setText("");
                updateplayerscore();
            }
        });

    }

    public boolean checkwinner(){
        boolean winnerresult = false;

        for (int [] winningposition : winnningpositions){
            if (gamestate[winningposition[0]] == gamestate[winningposition[1]] &&
                    gamestate[winningposition[1]] == gamestate[winningposition[2]] &&
                    gamestate[winningposition[0]] != 2){
                winnerresult = true;
            }

        }
        return winnerresult;
    }



    public void updateplayerscore(){
        playeronescore.setText(Integer.toString(playeronescorecount));
        playertwoscore.setText(Integer.toString(playertwoscorecount));
    }

    public void playagain(){
        rountcount = 0;
        activeplayer  = true;

        for (int i = 0; i < buttons.length; i++){
            gamestate[i] = 2;
            buttons[i].setText("");
        }
    }

}