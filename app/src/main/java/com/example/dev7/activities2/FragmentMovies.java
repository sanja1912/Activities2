package com.example.dev7.activities2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class FragmentMovies extends Fragment {

    private RecyclerView recyclerView;
    private Adapter adapter;
    private RecyclerView.LayoutManager manager;
    private List<ListOfMovies> list;
    private List<Integer>listOfImages;
    private List<String>listOfText;
    private List<String>listOfHead;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_fragment_movies,container,false);

        listOfText=new ArrayList<>();
        listOfImages=new ArrayList<>();
        listOfHead=new ArrayList<>();

        listOfImages.add(R.drawable.shutter_island);
        listOfImages.add(R.drawable.lion);
        listOfImages.add(R.drawable.invisible_guest);
        listOfImages.add(R.drawable.gone_girl);
        listOfImages.add(R.drawable.titanic);

        listOfText.add(getString(R.string.shutter_description));
        listOfText.add(getString(R.string.lion_description));
        listOfText.add(getString(R.string.invisible_guest_description));
        listOfText.add(getString(R.string.gone_girl_description));
        listOfText.add(getString(R.string.titanic_description));


        listOfHead.add(getString(R.string.shutter_title));
        listOfHead.add(getString(R.string.lion_title));
        listOfHead.add(getString(R.string.invisible_guest_title));
        listOfHead.add(getString(R.string.gone_girl_title));
        listOfHead.add(getString(R.string.titanic_title));

        recyclerView=rootView.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        manager=new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(manager);

        list=new ArrayList<>();
        for(int i=0;i<5;i++){
            ListOfMovies listOfMovies=new ListOfMovies();
            listOfMovies.setHeader(listOfHead.get(i));
            listOfMovies.setImage(listOfImages.get(i));
            listOfMovies.setDescription(listOfText.get(i));

            list.add(listOfMovies);

        }

        adapter=new Adapter(this.getContext());
        recyclerView.setAdapter(adapter);
        adapter.setList(list);



        return rootView;

    }

}
