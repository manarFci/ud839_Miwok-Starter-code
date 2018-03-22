package com.example.android.miwok;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    private MediaPlayer.OnCompletionListener vCompletionListener =new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

       final ArrayList<Word> englishWords=new ArrayList<Word>();
        englishWords.add(new Word("One","lutti",R.drawable.number_one,R.raw.number_one));
        englishWords.add(new Word("Two","Otiiko",R.drawable.number_two,R.raw.number_two));
        englishWords.add(new Word("Three","tolookosu",R.drawable.number_three,R.raw.number_three));
        englishWords.add(new Word("Four","oyyisa",R.drawable.number_four,R.raw.number_four));
        englishWords.add(new Word("Five","massokka",R.drawable.number_five,R.raw.number_five));
        englishWords.add(new Word("Six","temmokka",R.drawable.number_six,R.raw.number_six));
        englishWords.add(new Word("Seven","kenekako",R.drawable.number_seven,R.raw.number_seven));
        englishWords.add(new Word("Eight","kawinta",R.drawable.number_eight,R.raw.number_eight));
        englishWords.add(new Word("Nine","wo'e",R.drawable.number_nine,R.raw.number_nine));
        englishWords.add(new Word("Ten","na'aacha",R.drawable.number_ten,R.raw.number_ten));

        wordAdapter itemsAdapter = new wordAdapter(this , englishWords,R.color.category_numbers);

       ListView listView = (ListView) findViewById(R.id.list);
      //  GridView gridWords=(GridView) findViewById(R.id.gridview);

        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Word word = englishWords.get(position);
                releaseMediaPlayer();
               mediaPlayer=MediaPlayer.create(NumbersActivity.this, word.getAudioResourceId());

                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(vCompletionListener);
            }
        });

        /*LinearLayout NumbersLayout=(LinearLayout) findViewById(R.id.NumbersLayout);
        for (int i=0;i< englishWords.size();i++) {
            TextView wordView = new TextView(this);
            wordView.setText(englishWords.get(i));
            NumbersLayout.addView(wordView);

        }*/
    }
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }
}
