package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // OnClick listener for numbers
        TextView numbers = (TextView) findViewById(R.id.numbers);
        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent sendIntent = new Intent(MainActivity.this, NumbersActivity.class);
                startActivity(sendIntent);
            }
        });

        // OnClick listener for family
        TextView family = (TextView) findViewById(R.id.family);
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent sendIntent = new Intent(MainActivity.this, FamilyActivity.class);
                startActivity(sendIntent);
            }
        });

        // OnClick listener for colors
        TextView colors = (TextView) findViewById(R.id.colors);
        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent sendIntent = new Intent(MainActivity.this, ColorsActivity.class);
                startActivity(sendIntent);
            }
        });

        // OnClick listener for phrases
        TextView phrases = (TextView) findViewById(R.id.phrases);
        phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent sendIntent = new Intent(MainActivity.this, PhrasesActivity.class);
                startActivity(sendIntent);
            }
        });


    }


//
//    {
//
//    }


}
