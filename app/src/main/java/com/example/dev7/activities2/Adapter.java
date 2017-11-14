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

/**
 * Created by dev7 on 10.11.17..
 */

public class Adapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ListOfMovies> list=new ArrayList<>();

    private Context context;

    public Adapter( Context context) {
        this.context = context;
    }

    public void setList(List<ListOfMovies> list) {

        this.list = list;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
        return new MovieViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MovieViewHolder movieHolder = (MovieViewHolder) holder;

        final ListOfMovies listOfMovies = list.get(position);

        movieHolder.tvHead.setText(listOfMovies.getHeader());
        Glide.with(context)
                .load(listOfMovies.getImage())
                .into(movieHolder.imageView);

        movieHolder.listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,ThirdActivity.class);
                intent.putExtra("oneObject",listOfMovies);
                context.startActivity(intent);
            }
        });


    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder{
        public TextView tvHead;
        public ImageView imageView;
        public View listItemView;


        public MovieViewHolder(View itemView){
            super(itemView);
            listItemView=itemView;
            tvHead=itemView.findViewById(R.id.text_view_header);
            imageView=itemView.findViewById(R.id.image_id);

        }



    }
}
