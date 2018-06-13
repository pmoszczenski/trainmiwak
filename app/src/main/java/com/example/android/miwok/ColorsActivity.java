package com.example.android.miwok;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> word = new ArrayList<Word>();
        word.add(new Word ("red", "wetetti"));
        word.add(new Word ("green", "chokokki"));
        word.add(new Word ("brown", "takakki"));
        word.add(new Word ("gray", "takakkia"));
        word.add(new Word ("blakc", "kukulais"));
        word.add(new Word ("white", "kelell"));
        word.add(new Word ("dusty yellow", "toplisa"));
        word.add(new Word ("mustard yellow", "chiwiita"));


        WordAdapter itemsAdapter = new WordAdapter
                (this, word, R.color.category_colors);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

    }}

