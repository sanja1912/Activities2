package com.example.dev7.activities2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager manager;
    private List<ListOfMovies> list;
    private List<Integer>listOfImages;

    private List<String>listOfHead;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);



        listOfHead=new ArrayList<>();

        listOfImages=new ArrayList<>();

        listOfImages.add(R.drawable.shutter_island);
        listOfImages.add(R.drawable.lion);
        listOfImages.add(R.drawable.invisible_guest);
        listOfImages.add(R.drawable.gone_girl);
        listOfImages.add(R.drawable.titanic);







        listOfHead.add(getString(R.string.shutter_title));
        listOfHead.add(getString(R.string.lion_title));
        listOfHead.add(getString(R.string.invisible_guest_title));
        listOfHead.add(getString(R.string.gone_girl_title));
        listOfHead.add(getString(R.string.titanic_title));

        recyclerView=findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        manager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        list=new ArrayList<>();
        for(int i=0;i<5;i++){
            ListOfMovies listOfMovies=new ListOfMovies();
            listOfMovies.setImage(listOfImages.get(i));
            listOfMovies.setHeader(listOfHead.get(i));


            list.add(listOfMovies);

        }

        adapter=new MyAdapter(list,getApplicationContext());
        recyclerView.setAdapter(adapter);




    }



}




