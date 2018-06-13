package com.example.android.miwok;

import android.content.Context;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    MediaPlayer mMediaPlayer;

    private AudioManager mAudioManager = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
    AudioManager.OnAudioFocusChangeListener afListener = new AudioManager.OnAudioFocusChangeListener() {

        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                mMediaPlayer.release();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) {
                mMediaPlayer.release();
            } else if (focusChange == AudioManager.AUDIOFOCUS_REQUEST_FAILED) {
                mMediaPlayer.release();
            } else if (focusChange == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                mMediaPlayer.start();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> word = new ArrayList<Word>();
        word.add(new Word("one", "lutti", R.drawable.number_one, R.raw.number_one));
        word.add(new Word("two", "otiiko", R.drawable.number_two, R.raw.number_two));
        word.add(new Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
        word.add(new Word("four", "oyyissa", R.drawable.number_four, R.raw.number_four));
        word.add(new Word("five", "massoka", R.drawable.number_five, R.raw.number_five));
        word.add(new Word("six", "temmokka", R.drawable.number_six, R.raw.number_six));
        word.add(new Word("seven", "kenakaku", R.drawable.number_seven, R.raw.number_seven));
        word.add(new Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        word.add(new Word("nine", "wo'e", R.drawable.number_nine, R.raw.number_nine));
        word.add(new Word("ten", "naa'aacha", R.drawable.number_ten, R.raw.number_ten));

        WordAdapter itemsAdapter = new WordAdapter
                (this, word, R.color.category_numbers);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int i, long l) {
                int mSoundId;
                Word mWord = word.get(i);

                if (mMediaPlayer != null) {
                    mMediaPlayer.release();
                }

//                Logging lines
                Log.v("Numbers Activity", "Current word: " + mWord);

                mSoundId = mWord.getSoundId();
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, mSoundId);
                mAudioManager.requestAudioFocus
                        (afListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mAudioManager.abandonAudioFocus(afListener);
                    }
                });
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("Numbers Acti", "Activity has stopped");
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mAudioManager.abandonAudioFocus(afListener);
        }
        ;
    }
}
