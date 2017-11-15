package com.example.dev7.activities2;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class AdapterSong extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<ListOfSongs>list;
    private  Context context;

    public void setList(List<ListOfSongs> list) {
        this.list = list;
    }

    public AdapterSong(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.list_of_songs,parent,false);
        return new SongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        SongViewHolder songViewHolder=(SongViewHolder) holder;
        final ListOfSongs listOfSongs = list.get(position);
        songViewHolder.tvSong.setText(listOfSongs.getSong());
        songViewHolder.tvSinger.setText(listOfSongs.getSinger());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class SongViewHolder extends RecyclerView.ViewHolder{
        public TextView tvSong;
        public TextView tvSinger;


        public SongViewHolder(View itemView) {
            super(itemView);
            tvSong=itemView.findViewById(R.id.text_view_song);
            tvSinger=itemView.findViewById(R.id.text_view_singer);
        }
    }
}
