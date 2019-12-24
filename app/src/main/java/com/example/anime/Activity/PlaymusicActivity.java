package com.example.anime.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
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

import java.io.IOException;
import java.text.SimpleDateFormat;
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

    //MediaPlayer
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playmusic);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        GetDataFromIntent();
        init();
        eventClick();

    }

    private void eventClick() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(adapternhac.getItem(1) != null){
                    if(mangbaihat.size() > 0){
                        fragment_play_list_music_disc.Playnhac(mangbaihat.get(0).getAvatar());
                        handler.removeCallbacks(this);
                    }else {
                        handler.postDelayed(this,300);
                    }

                }            }
        },500);
        imgplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    imgplay.setImageResource(R.drawable.icon_play);
                }else {
                    mediaPlayer.start();
                    imgplay.setImageResource(R.drawable.icon_pause);
                }
            }
        });
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

        //
        fragment_play_list_music_disc = (Fragment_Play_list_music_disc) adapternhac.getItem(1);
        if(mangbaihat.size() > 0){
            getSupportActionBar().setTitle(mangbaihat.get(0).getTitle());
            new PlayMp3().execute(mangbaihat.get(0).getSongAddress());
            imgplay.setImageResource(R.drawable.icon_pause);

        }

    }

    class PlayMp3 extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... strings) {
                    return strings[0];
        }

        @Override
        protected void onPostExecute(String baihat) {
            super.onPostExecute(baihat);

            try {
                mediaPlayer = new MediaPlayer();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mediaPlayer.stop();
                        mediaPlayer.reset();
                    }
                });
                mediaPlayer.setDataSource(baihat);
                mediaPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
            mediaPlayer.start();
            TimeSong();
        }
    }

    private void TimeSong() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        txtTotaltimesong.setText(simpleDateFormat.format(mediaPlayer.getDuration()));
        sktime.setMax(mediaPlayer.getDuration());

    }

}
