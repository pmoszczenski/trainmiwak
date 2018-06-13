package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> word = new ArrayList<Word>();
        word.add(new Word ("Where are you going?", "minto wuksus"));
        word.add(new Word ("What is your name?", "tinnә oyaase'nә"));
        word.add(new Word ("My name is...", "oyaaset"));

        WordAdapter itemsAdapter = new WordAdapter
                (this, word, R.color.category_phrases);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

    }}

