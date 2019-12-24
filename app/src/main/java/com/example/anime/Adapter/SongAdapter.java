package com.example.anime.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anime.Activity.PlaymusicActivity;
import com.example.anime.Model.Song;
import com.example.anime.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHoldel> {
    Context context;
    ArrayList<Song> baihatArrayList;

    public SongAdapter(Context context, ArrayList<Song> baihatArrayList) {
        this.context = context;
        this.baihatArrayList = baihatArrayList;
    }

    @NonNull
    @Override
    public ViewHoldel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_song,parent,false);
        return new ViewHoldel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoldel holder, int position) {
        Song baihat = baihatArrayList.get(position);
        holder.txtcasi.setText(baihat.getVocal());
        holder.txtten.setText(baihat.getTitle());
        Picasso.with(context).load(baihat.getAvatar()).into(holder.imghinh);
    }

    @Override
    public int getItemCount() {
        return baihatArrayList.size();
    }

    public class ViewHoldel extends RecyclerView.ViewHolder{

        TextView txtten,txtcasi;
        ImageView imghinh,imgluotthich;

        public ViewHoldel(@NonNull View itemView) {
            super(itemView);
            txtten = itemView.findViewById(R.id.textview_namesong);
            txtcasi = itemView.findViewById(R.id.textview_vocal);
            imghinh = itemView.findViewById(R.id.imageview_song);
            imgluotthich = itemView.findViewById(R.id.imageview_love);

            //floating action button
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, PlaymusicActivity.class);
                    intent.putExtra("song",baihatArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
