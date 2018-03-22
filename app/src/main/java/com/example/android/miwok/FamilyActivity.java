package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
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
        final ArrayList<Word> FamilyList=new ArrayList<Word>();
        FamilyList.add(new Word("father","әpә",R.drawable.family_father,R.raw.family_father));
        FamilyList.add(new Word("mother","әṭa",R.drawable.family_mother,R.raw.family_mother));
        FamilyList.add(new Word("son","angsi",R.drawable.family_son,R.raw.family_son));
        FamilyList.add(new Word("daughter","tune",R.drawable.family_daughter,R.raw.family_daughter));
        FamilyList.add(new Word("older brother","taachi",R.drawable.family_older_brother,R.raw.family_older_brother));
        FamilyList.add(new Word("younger brother","chalitti",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        FamilyList.add(new Word("older sister","teṭe",R.drawable.family_older_sister,R.raw.family_older_sister));
        FamilyList.add(new Word("younger sister","kolliti",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        FamilyList.add(new Word("grandmother","ama",R.drawable.family_grandmother,R.raw.family_grandmother));
        FamilyList.add(new Word("grandfather","paapa",R.drawable.family_grandfather,R.raw.family_grandfather));


        wordAdapter itemsAdapter = new wordAdapter(this , FamilyList,R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.list);
        //  GridView gridWords=(GridView) findViewById(R.id.gridview);

        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Word word = FamilyList.get(position);
                releaseMediaPlayer();
                mediaPlayer= MediaPlayer.create(FamilyActivity.this, word.getAudioResourceId());

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
