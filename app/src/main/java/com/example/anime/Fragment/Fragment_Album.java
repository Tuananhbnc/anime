package com.example.anime.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anime.Activity.MainActivity;
import com.example.anime.Adapter.AlbumAdapter;
import com.example.anime.Model.Album;
import com.example.anime.R;
import com.example.anime.Service.APIService;
import com.example.anime.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Album extends Fragment {
    View view;
    RecyclerView recyclerViewalbum;
    TextView txtxemthemalbum;
    AlbumAdapter albumAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_album,container,false);
        anhxa();
        GetData();
        return view;
    }

    private void anhxa(){
        recyclerViewalbum = view.findViewById(R.id.recyclerviewAlbum);
        txtxemthemalbum = view.findViewById(R.id.textviewxemthemAlbum);
    }

    private void GetData() {
        String authHeader = "Bearer " + MainActivity.token.getIdToken();

        Dataservice dataservice = APIService.getService();
        Call<List<Album>> callback = dataservice.Getalbums(authHeader);
        callback.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                ArrayList<Album> albumArrayList = (ArrayList<Album>) response.body();
                albumAdapter = new AlbumAdapter(getActivity(),albumArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerViewalbum.setLayoutManager(linearLayoutManager);
                recyclerViewalbum.setAdapter(albumAdapter);
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {

            }
        });
    }

}
