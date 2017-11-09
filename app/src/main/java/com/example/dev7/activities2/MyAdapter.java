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

import java.io.Serializable;
import java.util.List;

/**
 * Created by dev7 on 7.11.17..
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    List<ListOfMovies>list;
    private Context context;

    public MyAdapter(List<ListOfMovies> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ListOfMovies listOfMovies = list.get(position);

        holder.tvHead.setText(listOfMovies.getHeader());
        holder.tvDescription.setText(listOfMovies.getDescription());

        Glide.with(context)
                .load(listOfMovies.getImage())
                .into(holder.imageView);


        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, ThirdActivity.class);
                intent.putExtra("oneObject", listOfMovies);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tvHead;
        public TextView tvDescription;
        public ImageView imageView;

        public ViewHolder(View itemView){
            super(itemView);
            tvHead=itemView.findViewById(R.id.text_view_header);
            tvDescription=itemView.findViewById(R.id.text_view_description);
            imageView=itemView.findViewById(R.id.image_id);


        }



    }

}
