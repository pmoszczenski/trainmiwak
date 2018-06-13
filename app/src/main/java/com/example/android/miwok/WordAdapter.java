package com.example.android.miwok;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Xeos on 2017-02-07.
 */


public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;

//    private MediaPlayer soundPlayer = MediaPlayer.create(getContext(), R.raw.habit);
//
//    private void buildPlayer(int soundRes) {
//        soundPlayer = MediaPlayer.create(getContext(), soundRes);
//        soundPlayer.start();
//        soundResChecksum = soundRes;
//    }
//
//    private int soundResChecksum;

    public WordAdapter(Activity context, ArrayList<Word> word, int color) {
        super(context, 0, word);
        mColorResourceId = color;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        final Word word = getItem(position);

        TextView englishTextView = (TextView) listItemView.findViewById(R.id.miwok);
        englishTextView.setText(word.getMiwokTranslation());

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.english);
        miwokTextView.setText(word.getEnglishTranslation());

        ImageView iconImageView = (ImageView) listItemView.findViewById(R.id.icon);
        if (word.getResId() != 0) {
            iconImageView.setImageResource(word.getResId());
            iconImageView.setVisibility(View.VISIBLE);
        } else {
            iconImageView.setVisibility(View.GONE);
        }

        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        listItemView.setBackgroundColor(color);

//        final int soundRes = word.getSoundId();
//        if (soundRes != 0) {
//            listItemView.setOnClickListener
//                    (new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            if (soundPlayer.isPlaying() && soundRes == soundResChecksum) {
//                                soundPlayer.reset();
//                                soundResChecksum = 0;
//                            }
//                            else {
//                                soundPlayer.release();
//                                buildPlayer(soundRes);
//                                Toast.makeText(getContext(), "Starting playing", Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    });
//        }


        return listItemView;
    }
}