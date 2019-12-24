package com.example.anime.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anime.Model.Song;
import com.example.anime.R;

public class PlaymusicActivity extends AppCompatActivity {

    Toolbar toolbarplaynhac;
    TextView txtTimesong,txtTotaltimesong;
    SeekBar sktime;
    ImageButton imgplay, imgrepeat, imgnext, imgpre, imgrandom;
    ViewPager viewPagerplaynhac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playmusic);
        init();

        // floating action
        Intent intent = getIntent();
        if(intent.hasExtra("song")){
            Song song = intent.getParcelableExtra("song");
            Toast.makeText(this, song.getTitle(), Toast.LENGTH_SHORT).show();
        }

    }

    private void init() {
        toolbarplaynhac = findViewById(R.id.toolbarplaynhac);
        txtTimesong = findViewById(R.id.textviewtimesong);
        txtTotaltimesong = findViewById(R.id.textviewtotaltimesong);
        sktime = findViewById(R.id.seekbarsong);
        imgplay = findViewById(R.id.imagebuttonplay);
        imgrepeat = findViewById(R.id.imagebuttonpepeat);
        imgnext = findViewById(R.id.imagebuttonnext);
        imgrandom = findViewById(R.id.imagebuttonsuffle);
        imgpre = findViewById(R.id.imagebuttonpre);
        viewPagerplaynhac = findViewById(R.id.viewpagerplaynhac);
        setSupportActionBar(toolbarplaynhac);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarplaynhac.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        toolbarplaynhac.setTitleTextColor(Color.WHITE);
    }
}
