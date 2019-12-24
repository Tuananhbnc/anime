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

import com.example.anime.Adapter.ViewPagerPlaylistMusic;
import com.example.anime.Fragment.Fragment_Play_list_music_disc;
import com.example.anime.Fragment.Fragment_Play_list_song;
import com.example.anime.Model.Song;
import com.example.anime.R;

import java.util.ArrayList;

public class PlaymusicActivity extends AppCompatActivity {

    Toolbar toolbarplaynhac;
    TextView txtTimesong,txtTotaltimesong;
    SeekBar sktime;
    ImageButton imgplay, imgrepeat, imgnext, imgpre, imgrandom;
    ViewPager viewPagerplaynhac;
    public static ArrayList<Song> mangbaihat = new ArrayList<>();
    public static ViewPagerPlaylistMusic adapternhac;
    Fragment_Play_list_music_disc fragment_play_list_music_disc;
    Fragment_Play_list_song fragment_play_list_song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playmusic);
        init();
        GetDataFromIntent();


    }

    private void GetDataFromIntent() {
        // floating action
        Intent intent = getIntent();
        mangbaihat.clear();
        if(intent != null){
            if(intent.hasExtra("song")){
                Song song = intent.getParcelableExtra("song");
                //Toast.makeText(this, song.getTitle(), Toast.LENGTH_SHORT).show();
                mangbaihat.add(song);
            }
            if(intent.hasExtra("cacbaihat")){
                ArrayList<Song> bahatArrayList = intent.getParcelableArrayListExtra("cacbaihat");
                mangbaihat = bahatArrayList;
            }
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

        //
        fragment_play_list_music_disc = new Fragment_Play_list_music_disc();
        fragment_play_list_song = new Fragment_Play_list_song();

        adapternhac = new ViewPagerPlaylistMusic(getSupportFragmentManager());
        adapternhac.addFragment(fragment_play_list_song);
        adapternhac.addFragment(fragment_play_list_music_disc);
        viewPagerplaynhac.setAdapter(adapternhac);

    }
}
