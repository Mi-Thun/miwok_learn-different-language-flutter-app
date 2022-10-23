package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Red","Wetetti",R.drawable.color_red, R.raw.color_red));
        words.add(new Word("Green","Chokokki",R.drawable.color_green, R.raw.color_green));
        words.add(new Word("Brown","Takaakki",R.drawable.color_brown, R.raw.color_brown));
        words.add(new Word("Gray","Topoppi",R.drawable.color_gray, R.raw.color_gray));
        words.add(new Word("Black","Kululli",R.drawable.color_black, R.raw.color_black));
        words.add(new Word("White","Kelelli",R.drawable.color_white, R.raw.color_white));
        words.add(new Word("Dust Yellow","Topiisa",R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        words.add(new Word("Mustard Yellow","Chiwiita",R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

        WordAdapter adapter = new WordAdapter(this, words,R.color.category_colors);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);
                mMediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getmAudioResourceId());
                mMediaPlayer.start();
            }
        });
    }
}