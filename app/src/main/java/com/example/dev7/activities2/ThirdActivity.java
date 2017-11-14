package com.example.dev7.activities2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.EventLogTags;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ThirdActivity extends AppCompatActivity {
    public TextView tvHead;
    public TextView tvDescription;
    public ImageView imgView;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        tvHead=findViewById(R.id.tv_head);
        tvDescription=findViewById(R.id.tv_description);
        imgView=findViewById(R.id.image_idd);
        toolbar=findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



        ListOfMovies listOfMovies = (ListOfMovies) getIntent().getSerializableExtra("oneObject");

        Log.d("CHECK_PASS_OBJECT", "des: " + listOfMovies.getDescription());
        Log.d("CHECK_PASS_OBJECT", "header: " + listOfMovies.getHeader());
        Log.d("CHECK_PASS_OBJECT", "image: " + listOfMovies.getImage());

        tvHead.setText(listOfMovies.getHeader());
        tvDescription.setText(listOfMovies.getDescription());
        imgView.setImageResource(listOfMovies.getImage());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==android.R.id.home){
            this.finish();

        }
        return super.onOptionsItemSelected(item);
    }
}

