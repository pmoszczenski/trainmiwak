package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> word = new ArrayList<Word>();
        word.add(new Word ("father", "әpә"));
        word.add(new Word ("mother", "әṭa"));
        word.add(new Word ("son", "angsi"));
        word.add(new Word ("daughter", "tune"));

        WordAdapter itemsAdapter = new WordAdapter
                (this, word, R.color.category_family);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

    }}

