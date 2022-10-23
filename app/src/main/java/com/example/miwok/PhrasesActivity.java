package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Where are you going?","minto wuksus", R.raw.phrase_where_are_you_going));
        words.add(new Word("What is your name?","tinne oyaase'ne", R.raw.phrase_what_is_your_name));
        words.add(new Word("My name is..","oyaaset..", R.raw.phrase_my_name_is));
        words.add(new Word("How are you felling?","michekses?", R.raw.phrase_how_are_you_feeling));
        words.add(new Word("I'am felling good.","kuchi achit", R.raw.phrase_im_feeling_good));
        words.add(new Word("Are you coming?","eenes'aa?", R.raw.phrase_are_you_coming));
        words.add(new Word("Yes, I'am coming.","hee'eenem", R.raw.phrase_yes_im_coming));
        words.add(new Word("I'am coming","eenem", R.raw.phrase_im_coming));
        words.add(new Word("Let's go.","yoowutis", R.raw.phrase_lets_go));
        words.add(new Word("Come here.","enni'nem", R.raw.phrase_come_here));

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_phrases);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);
                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getmAudioResourceId());
                mMediaPlayer.start();
            }
        });
    }
}