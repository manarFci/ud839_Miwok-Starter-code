package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
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

        final ArrayList<Word> PhrasesList=new ArrayList<Word>();
        PhrasesList.add(new Word("Where are you going?","minto wuksus",R.raw.phrase_where_are_you_going));
        PhrasesList.add(new Word("What is your name?","tinnә oyaase'nә",R.raw.phrase_what_is_your_name));
        PhrasesList.add(new Word("My name is...","oyaaset..",R.raw.phrase_my_name_is));
        PhrasesList.add(new Word("How are you feeling?","michәksәs?",R.raw.phrase_how_are_you_feeling));
        PhrasesList.add(new Word("I’m feeling good.","kuchi achit",R.raw.phrase_im_feeling_good));
        PhrasesList.add(new Word("Are you coming?","әәnәs'aa?",R.raw.phrase_are_you_coming));
        PhrasesList.add(new Word("Yes, I’m coming.","hәә’ әәnәm",R.raw.phrase_yes_im_coming));
        PhrasesList.add(new Word("I’m coming.","әәnәm",R.raw.phrase_im_coming));
        PhrasesList.add(new Word("Let’s go.","yoowutis",R.raw.phrase_lets_go));
        PhrasesList.add(new Word("Come here.","әnni'nem",R.raw.phrase_come_here));


        wordAdapter itemsAdapter = new wordAdapter(this , PhrasesList,R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);
        //  GridView gridWords=(GridView) findViewById(R.id.gridview);



        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Word word = PhrasesList.get(position);
                releaseMediaPlayer();//2
                mediaPlayer= MediaPlayer.create(PhrasesActivity.this, word.getAudioResourceId());

                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(vCompletionListener);
            }
        });


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
