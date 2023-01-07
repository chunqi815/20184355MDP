package com.example.a20184355mdp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;
import io.realm.Sort;


public class TimelineFragment extends Fragment {

    private EditText journalEntryEditText;
    private TextView savedJournalEntriesTextView;
    private List<String> savedJournalEntries = new ArrayList<>();

    MaterialButton addNoteBtn;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_timeline, container, false);
        addNoteBtn = (MaterialButton)rootView .findViewById(R.id.addnewnotebtn);
        addNoteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddNoteActivity.class);
                startActivity(intent);
            }
        });
        Realm.init(getActivity().getApplicationContext());
        Realm realm = Realm.getDefaultInstance();

        RealmResults<JournalEntry> notesList = realm.where(JournalEntry.class).findAll().sort("createdTime", Sort.DESCENDING);


        recyclerView = (RecyclerView)rootView .findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        MyAdapter myAdapter = new MyAdapter(getActivity().getApplicationContext(),notesList);
        recyclerView.setAdapter(myAdapter);

        notesList.addChangeListener(new RealmChangeListener<RealmResults<JournalEntry>>() {
            @Override
            public void onChange(RealmResults<JournalEntry> notes) {
                myAdapter.notifyDataSetChanged();
            }
        });
        return rootView;
    }

    }
