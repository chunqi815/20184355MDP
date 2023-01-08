package com.example.a20184355mdp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;


public class DiscoverFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_discover, container, false);

        MaterialButton startMeditationBtn;
        MaterialButton startStoicismBtn;

        //start Meditation page
        startMeditationBtn = (MaterialButton)rootView .findViewById(R.id.startmeditationbtn);
        startMeditationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MeditationGuidePage.class);
                startActivity(intent);
            }
        });

        //start Stoicism page
        startStoicismBtn = (MaterialButton)rootView .findViewById(R.id.startstoicismbtn);
        startStoicismBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), StoicismGuidePage.class);
                startActivity(intent);
            }
        });

        return rootView;
    }
}