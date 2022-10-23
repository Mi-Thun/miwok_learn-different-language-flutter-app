package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("One","Lutti",R.drawable.number_one, R.raw.number_one));
        words.add(new Word("Two","Atiko",R.drawable.number_two, R.raw.number_two));
        words.add(new Word("Three","Tolookosu",R.drawable.number_three, R.raw.number_three));
        words.add(new Word("Four","Ayyisa",R.drawable.number_four, R.raw.number_four));
        words.add(new Word("Five","Massakka",R.drawable.number_five, R.raw.number_five));
        words.add(new Word("Six","Temmakka",R.drawable.number_six, R.raw.number_six));
        words.add(new Word("Seven","Kenekaku",R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("Eight","Kawinta",R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("Nine","wo'e",R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("Ten","Na'aacha",R.drawable.number_ten, R.raw.number_ten));

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getmAudioResourceId());
                mMediaPlayer.start();
            }
        });


//        LinearLayout rootView = findViewById(R.id.rootView);
//
//        int index = 0;
//        while (index != words.size()) {
//            TextView wordView = new TextView(this);
//            wordView.setText(words.get(index));
//            rootView.addView(wordView);
//            index++;
//        }



    }
}