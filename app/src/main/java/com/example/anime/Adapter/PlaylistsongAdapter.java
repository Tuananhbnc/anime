package com.example.anime.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anime.Model.Song;
import com.example.anime.R;

import java.util.ArrayList;

public class PlaylistsongAdapter extends RecyclerView.Adapter<PlaylistsongAdapter.ViewHolder> {

    Context context;
    ArrayList<Song> mangbaihat;

    public PlaylistsongAdapter(Context context, ArrayList<Song> mangbaihat) {
        this.context = context;
        this.mangbaihat = mangbaihat;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_play_list_song,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Song song = mangbaihat.get(position);
        holder.txtcasi.setText(song.getVocal());
        holder.txtindex.setText(position + 1 + "");
        holder.txttenbaihat.setText(song.getTitle());
    }

    @Override
    public int getItemCount() {
        return mangbaihat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtindex,txttenbaihat,txtcasi;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtcasi = itemView.findViewById(R.id.textviewplaynhactencasi);
            txttenbaihat = itemView.findViewById(R.id.textviewplaynhactenbaihat);
            txtindex = itemView.findViewById(R.id.textviewplaunhacindex);

        }
    }
}
