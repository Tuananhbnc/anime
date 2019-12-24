package com.example.anime.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.anime.Model.Song;
import com.example.anime.R;

public class PlaymusicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playmusic);

        // floating action
        Intent intent = getIntent();
        if(intent.hasExtra("song")){
            Song song = intent.getParcelableExtra("song");
            Toast.makeText(this, song.getTitle(), Toast.LENGTH_SHORT).show();
        }

    }
}
