package com.example.navwithtab;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class fragment3 extends Fragment {
    Button btn_tasbi,btn_converter,btn_calculator;


    public fragment3() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_fragment3, container, false);
        btn_tasbi = v.findViewById(R.id.btn_tasbi);
        btn_tasbi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),tasbi.class));
            }
        });

        btn_converter = v.findViewById(R.id.btn_converter);
        btn_converter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),converter.class));
            }
        });

        btn_calculator = v.findViewById(R.id.btn_calculator);
        btn_calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),calculator.class));
                Toast.makeText(getContext(), "Coming Soon", Toast.LENGTH_LONG).show();
            }
        });




        return v;
    }
}