//package com.example.dev7.activities2;
//
//import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.support.v7.widget.Toolbar;
//import android.view.MenuItem;
//import android.widget.ImageView;
//import java.util.ArrayList;
//import java.util.List;
//
//public class SecondActivity extends AppCompatActivity {
//    Toolbar toolbar;
//
//    private RecyclerView recyclerView;
//    private Adapter adapter;
//    private RecyclerView.LayoutManager manager;
//    private List<ListOfMovies> list;
//    private List<Integer>listOfImages;
//    private List<String>listOfText;
//    private List<String>listOfHead;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_second);
//
//        toolbar=findViewById(R.id.my_toolbar);
//        setSupportActionBar(toolbar);
//
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//
//
//
//
//
//
//        listOfHead=new ArrayList<>();
//        listOfText=new ArrayList<>();
//        listOfImages=new ArrayList<>();
//
//        listOfImages.add(R.drawable.shutter_island);
//        listOfImages.add(R.drawable.lion);
//        listOfImages.add(R.drawable.invisible_guest);
//        listOfImages.add(R.drawable.gone_girl);
//        listOfImages.add(R.drawable.titanic);
//
//        listOfText.add(getString(R.string.shutter_description));
//        listOfText.add(getString(R.string.lion_description));
//        listOfText.add(getString(R.string.invisible_guest_description));
//        listOfText.add(getString(R.string.gone_girl_description));
//        listOfText.add(getString(R.string.titanic_description));
//
//
//        listOfHead.add(getString(R.string.shutter_title));
//        listOfHead.add(getString(R.string.lion_title));
//        listOfHead.add(getString(R.string.invisible_guest_title));
//        listOfHead.add(getString(R.string.gone_girl_title));
//        listOfHead.add(getString(R.string.titanic_title));
//
//        recyclerView=findViewById(R.id.recycler_view);
//        recyclerView.setHasFixedSize(true);
//
//        manager=new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(manager);
//
//        list=new ArrayList<>();
//        for(int i=0;i<5;i++){
//            ListOfMovies listOfMovies=new ListOfMovies();
//            listOfMovies.setImage(listOfImages.get(i));
//            listOfMovies.setHeader(listOfHead.get(i));
//            listOfMovies.setDescription(listOfText.get(i));
//
//            list.add(listOfMovies);
//
//        }
//
//        adapter=new Adapter(this);
//        recyclerView.setAdapter(adapter);
//        adapter.setList(list);
//
//
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id=item.getItemId();
//        if(id==android.R.id.home){
//            this.finish();
//
//        }
//        return super.onOptionsItemSelected(item);
//    }
//}




