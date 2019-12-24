package com.example.anime.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anime.Activity.PlaymusicActivity;
import com.example.anime.Adapter.PlaylistsongAdapter;
import com.example.anime.R;

public class Fragment_Play_list_song extends Fragment {
    View view;
    RecyclerView recyclerViewplaynhac;
    PlaylistsongAdapter playlistsongAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_play_list_song,container,false);
        recyclerViewplaynhac = view.findViewById(R.id.recyclerviewPlaybaihat);
        if (PlaymusicActivity.mangbaihat.size() > 0){
            playlistsongAdapter = new PlaylistsongAdapter(getActivity(), PlaymusicActivity.mangbaihat);
            recyclerViewplaynhac.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerViewplaynhac.setAdapter(playlistsongAdapter);
        }
        return view;
    }
}
