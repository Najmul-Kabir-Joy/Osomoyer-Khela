package com.example.navwithtab;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


public class fragment1 extends Fragment {

    Button btn_tictactoe, btn_roulette, btn_guessinggame, btn_bottlespinner, btn_oddevendice, btn_calculationgame, btn_dicecount;



    public fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment1, container, false);

        btn_tictactoe = v.findViewById(R.id.btn_tictactoe);
        btn_tictactoe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),tictactoe.class));
            }
        });

        btn_guessinggame = v.findViewById(R.id.btn_guessinggame);
        btn_guessinggame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),guessinggame.class));
            }
        });

        btn_roulette = v.findViewById(R.id.btn_roulette);
        btn_roulette.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),roulette.class));
            }
        });

        btn_bottlespinner = v.findViewById(R.id.btn_bottlespinner);
        btn_bottlespinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),bottlespinner.class));
            }
        });

        btn_calculationgame = v.findViewById(R.id.btn_calculationgame);
        btn_calculationgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),calculation.class));
            }
        });

        btn_dicecount = v.findViewById(R.id.btn_dicecount);
        btn_dicecount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),dicecount.class));
            }
        });

        btn_oddevendice = v.findViewById(R.id.btn_oddevendice);
        btn_oddevendice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),oddevendice.class));
            }
        });


        return v;
    }
}