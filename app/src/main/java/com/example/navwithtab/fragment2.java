package com.example.navwithtab;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class fragment2 extends Fragment {

    Button btn_alphabet, btn_colors, btn_rhymes, btn_kobita, btn_bornomala,btn_animals;


    public fragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment2, container, false);
        btn_alphabet = v.findViewById(R.id.btn_alphabet);
        btn_alphabet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),alphabet.class));
            }
        });

        btn_colors = v.findViewById(R.id.btn_colors);
        btn_colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),colors.class));
            }
        });

        btn_rhymes = v.findViewById(R.id.btn_rhymes);
        btn_rhymes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),rhymes.class));
            }
        });

        btn_kobita = v.findViewById(R.id.btn_kobita);
        btn_kobita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),kobita.class));
            }
        });

        btn_bornomala = v.findViewById(R.id.btn_bornomala);
        btn_bornomala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),bornomala.class));
            }
        });

        btn_animals = v.findViewById(R.id.btn_animals);
        btn_animals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),animals.class));
            }
        });




        return v;

    }
}