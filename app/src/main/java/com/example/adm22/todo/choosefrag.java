package com.example.adm22.todo;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class choosefrag extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.choosefragment, null);


        final FragmentManager fragmentManager1 = getFragmentManager();

        final Button sport = (Button) v.findViewById(R.id.buttonspotr);
        final Button work = (Button) v.findViewById(R.id.buttonwork);


        sport.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                fragmentManager1.beginTransaction()
                        .remove(ScrollingActivity.fraaag)
                        .commit();

                ScrollingActivity.spf();

            }
        });


        work.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                fragmentManager1.beginTransaction()
                        .remove(ScrollingActivity.fraaag)
                        .commit();

                ScrollingActivity.wrf();
            }
        });



        return v;
    }
}