package com.example.a20184355mdp;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;
import io.realm.Sort;


public class TimelineFragment extends Fragment {

    private EditText journalEntryEditText;
    private TextView savedJournalEntriesTextView;
    private List<String> savedJournalEntries = new ArrayList<>();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_timeline, container, false);
        MaterialButton allJournalsBtn;
        //see all journals
        allJournalsBtn = (MaterialButton)rootView .findViewById(R.id.seealljournalsbtn);
        allJournalsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AllJournalsPage.class);
                startActivity(intent);
            }
        });

        return rootView;
    }

    }
