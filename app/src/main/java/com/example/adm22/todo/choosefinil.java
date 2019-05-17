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
/**
 * Created by adm22 on 06.07.2017.
 */

public class choosefinil extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.choosefin, null);


        final FragmentManager fragmentManager1 = getFragmentManager();

        final Button win = (Button) v.findViewById(R.id.win);
        final Button norm = (Button) v.findViewById(R.id.norm);
        final Button lose = (Button) v.findViewById(R.id.lose);
        final Button back = (Button) v.findViewById(R.id.back);


        win.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                fragmentManager1.beginTransaction()
                        .remove(ScrollingActivity.fragfn)
                        .commit();


            }
        });

        norm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                fragmentManager1.beginTransaction()
                        .remove(ScrollingActivity.fragfn)
                        .commit();

            }
        });

        lose.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                fragmentManager1.beginTransaction()
                        .remove(ScrollingActivity.fragfn)
                        .commit();

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                fragmentManager1.beginTransaction()
                        .remove(ScrollingActivity.fragfn)
                        .commit();

            }
        });

        return v;
    }

}
