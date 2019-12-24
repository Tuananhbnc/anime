package com.example.anime.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anime.Activity.MainActivity;
import com.example.anime.Adapter.SongAdapter;
import com.example.anime.Model.Song;
import com.example.anime.Model.Token;
import com.example.anime.R;
import com.example.anime.Service.APIService;
import com.example.anime.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Song extends Fragment {
    View view;
    RecyclerView recyclerViewsongs;
    SongAdapter songAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_song,container,false);
        anhxa();
        GetData();
        return view;
    }

    private void GetData() {
        String authHeader = "Bearer " + MainActivity.token.getIdToken();

        Dataservice dataservice = APIService.getService();
        Call<List<Song>> call = dataservice.Getsongs(authHeader);
        call.enqueue(new Callback<List<Song>>() {
            @Override
            public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                ArrayList<Song> songArray = (ArrayList<Song>) response.body();
                songAdapter = new SongAdapter(getActivity(),songArray);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
                recyclerViewsongs.setLayoutManager(linearLayoutManager);
                recyclerViewsongs.setAdapter(songAdapter);
            }

            @Override
            public void onFailure(Call<List<Song>> call, Throwable t) {

            }
        });
    }

    private void anhxa() {
        recyclerViewsongs = view.findViewById(R.id.recyclerview_songs);
    }
}
