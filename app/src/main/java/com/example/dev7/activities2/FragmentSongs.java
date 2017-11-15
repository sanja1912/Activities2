package com.example.dev7.activities2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class FragmentSongs extends Fragment {
    private RecyclerView recyclerView;
    private AdapterSong adapter;
    private RecyclerView.LayoutManager manager;
    private List<ListOfSongs> list;
    private List<String>listOfSongs;
    private List<String>listOfSingers;
    Toolbar toolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_fragment_songs,container,false);


        listOfSongs=new ArrayList<>();
        listOfSingers=new ArrayList<>();

        listOfSongs.add(getString(R.string.havana_song));
        listOfSongs.add(getString(R.string.what_about_us));
        listOfSongs.add(getString(R.string.attention_song));
        listOfSongs.add(getString(R.string.broken_glass_song));
        listOfSongs.add(getString(R.string.love_so_soft_song));
        listOfSongs.add(getString(R.string.if_i_am_lucky_song));
        listOfSongs.add(getString(R.string.too_good_at_goodbyes_song));
        listOfSongs.add(getString(R.string.young_dumb_and_broke_song));
        listOfSongs.add(getString(R.string.wait_song));
        listOfSongs.add(getString(R.string.alone_song));


        listOfSingers.add(getString(R.string.havana_singer));
        listOfSingers.add(getString(R.string.what_about_us_singer));
        listOfSingers.add(getString(R.string.attention_singer));
        listOfSingers.add(getString(R.string.broken_glass_singer));
        listOfSingers.add(getString(R.string.love_so_soft_singer));
        listOfSingers.add(getString(R.string.if_i_am_lucky_singer));
        listOfSingers.add(getString(R.string.too_good_at_goodbyes_singer));
        listOfSingers.add(getString(R.string.young_dumb_and_broke_singer));
        listOfSingers.add(getString(R.string.wait_singer));
        listOfSingers.add(getString(R.string.alone_singer));

        recyclerView=rootView.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        manager=new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(manager);

        list=new ArrayList<>();
        for(int i=0;i<10;i++){
            ListOfSongs ls=new ListOfSongs();
            ls.setSong(listOfSongs.get(i));
            ls.setSinger(listOfSingers.get(i));

            list.add(ls);


        }

        adapter=new AdapterSong(this.getContext());
        recyclerView.setAdapter(adapter);
        adapter.setList(list);

        return rootView;

    }


}
