//package com.example.dev7.activities2;
//
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.support.v7.widget.Toolbar;
//import android.view.MenuItem;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class FourthActivity extends AppCompatActivity {
//    private RecyclerView recyclerView;
//    private AdapterSong adapter;
//    private RecyclerView.LayoutManager manager;
//    private List<ListOfSongs> list;
//    private List<String>listOfSongs;
//    private List<String>listOfSingers;
//    Toolbar toolbar;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_fourth);
//
//        toolbar=findViewById(R.id.my_toolbar);
//        setSupportActionBar(toolbar);
//
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//
//
//        listOfSongs=new ArrayList<>();
//        listOfSingers=new ArrayList<>();
//
//        listOfSongs.add(getString(R.string.havana_song));
//        listOfSongs.add(getString(R.string.what_about_us));
//        listOfSongs.add(getString(R.string.attention_song));
//        listOfSongs.add(getString(R.string.broken_glass_song));
//        listOfSongs.add(getString(R.string.love_so_soft_song));
//        listOfSongs.add(getString(R.string.if_i_am_lucky_song));
//        listOfSongs.add(getString(R.string.too_good_at_goodbyes_song));
//        listOfSongs.add(getString(R.string.young_dumb_and_broke_song));
//        listOfSongs.add(getString(R.string.wait_song));
//        listOfSongs.add(getString(R.string.alone_song));
//
//
//        listOfSingers.add(getString(R.string.havana_singer));
//        listOfSingers.add(getString(R.string.what_about_us_singer));
//        listOfSingers.add(getString(R.string.attention_singer));
//        listOfSingers.add(getString(R.string.broken_glass_singer));
//        listOfSingers.add(getString(R.string.love_so_soft_singer));
//        listOfSingers.add(getString(R.string.if_i_am_lucky_singer));
//        listOfSingers.add(getString(R.string.too_good_at_goodbyes_singer));
//        listOfSingers.add(getString(R.string.young_dumb_and_broke_singer));
//        listOfSingers.add(getString(R.string.wait_singer));
//        listOfSingers.add(getString(R.string.alone_singer));
//
//        recyclerView=findViewById(R.id.recycler_view);
//        recyclerView.setHasFixedSize(true);
//
//        manager=new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(manager);
//
//        list=new ArrayList<>();
//        for(int i=0;i<10;i++){
//            ListOfSongs ls=new ListOfSongs();
//            ls.setSong(listOfSongs.get(i));
//            ls.setSinger(listOfSingers.get(i));
//
//            list.add(ls);
//
//
//        }
//
//        adapter=new AdapterSong(this);
//        recyclerView.setAdapter(adapter);
//        adapter.setList(list);
//
//
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
//        } return super.onOptionsItemSelected(item);
//    }
//}
