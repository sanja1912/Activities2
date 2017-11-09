package com.example.dev7.activities2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.EventLogTags;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ThirdActivity extends AppCompatActivity {
    public TextView tvHead;
    public TextView tvDescription;
    public ImageView imgView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        tvHead=findViewById(R.id.tv_head);
        tvDescription=findViewById(R.id.tv_description);
        imgView=findViewById(R.id.image_idd);


        ListOfMovies listOfMovies = (ListOfMovies) getIntent().getSerializableExtra("oneObject");

        Log.d("CHECK_PASS_OBJECT", "des: " + listOfMovies.getDescription());
        Log.d("CHECK_PASS_OBJECT", "header: " + listOfMovies.getHeader());
        Log.d("CHECK_PASS_OBJECT", "image: " + listOfMovies.getImage());



       String movie1=getString(R.string.shutter_description);
       String movie2=getString(R.string.lion_description);
       String movie3=getString(R.string.invisible_guest_description);
       String movie4=getString(R.string.gone_girl_description);
       String movie5=getString(R.string.titanic_description);

       String[] Description = {movie1,movie2,movie3,movie4,movie5};
       for(int i=0;i<Description.length;i++){
           listOfMovies.setDescription(Description[i]);


       }


        tvHead.setText(listOfMovies.getHeader());
        tvDescription.setText(listOfMovies.getDescription());
        imgView.setImageResource(listOfMovies.getImage());

    }
    }

