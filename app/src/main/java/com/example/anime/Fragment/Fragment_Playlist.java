package com.example.anime.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anime.R;

public class Fragment_Playlist extends Fragment {
    View view;
    RecyclerView recyclerView_Playlist;
    TextView txtxemthemPlaylist;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_playlist,container,false);
        anhxa();
        return view;
    }

    private void anhxa() {
        recyclerView_Playlist = view.findViewById(R.id.recyclerview_Playlist);
        txtxemthemPlaylist = view.findViewById(R.id.textviewxemthem_Playlist);
    }
}
