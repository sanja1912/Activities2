package com.example.dev7.activities2.fragment;


import android.arch.persistence.room.Room;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.dev7.activities2.R;
import com.example.dev7.activities2.adapter.Adapter;
import com.example.dev7.activities2.adapter.MovieAdapterServer;
import com.example.dev7.activities2.database.AppDatabase;
import com.example.dev7.activities2.model.Movie;
import com.example.dev7.activities2.model.MovieResponseServer;
import com.example.dev7.activities2.model.MovieServer;
import com.example.dev7.activities2.rest.MovieApiService;
import com.example.dev7.activities2.rest.ServiceGenerator;
import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.example.dev7.activities2.rest.ServiceGenerator.API_KEY;


public class FragmentMovies extends Fragment {
    private RecyclerView recyclerViewMovie,recyclerViewMovieServer;
    private Adapter adapter;
    private RecyclerView.LayoutManager manager,managerServer;
    private List<Movie> list=new ArrayList<>();
    public SwipeRefreshLayout swipeRefreshLayout;
    private ItemTouchHelper mItemTouchHelper;
    private AppDatabase db;
    private TextView tvHead;
    int position;
    private static final String TAG="";
    private MovieAdapterServer movieAdapter;
    private ServiceGenerator serviceGenerator;
    private MovieApiService movieApiService;

    List<MovieServer>localData=new ArrayList<>();




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        serviceGenerator=ServiceGenerator.getInstance();
        serviceGenerator.initializeRetrofit();
        movieApiService = serviceGenerator.getMovieApiService();
        list = new ArrayList<>();
        db = Room.databaseBuilder(getActivity().getApplicationContext(), AppDatabase.class, "movie_and_song")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
        list = db.movieDao().getAllMovie();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fragment_movies, container, false);

        recyclerViewMovie = rootView.findViewById(R.id.recycler_view1);
        recyclerViewMovie.setHasFixedSize(true);
        manager = new LinearLayoutManager(this.getContext());
        recyclerViewMovie.setLayoutManager(manager);
        movieAdapter = new MovieAdapterServer(this.getContext());
       recyclerViewMovie.setAdapter(movieAdapter);



        swipeRefreshLayout = rootView.findViewById(R.id.swipe_refresh);
        tvHead=rootView.findViewById(R.id.text_view_header);
        db= Room.databaseBuilder(getActivity().getApplicationContext(),AppDatabase.class,"movie_and_song")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                updateMovie();
                getTopRatedMovies();

            }
        });


        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                position = viewHolder.getAdapterPosition();
                if (direction == ItemTouchHelper.LEFT) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle("Are you sure to delete?");
                    builder.setPositiveButton("Remove", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            movieAdapter.notifyItemRemoved(position);
                            Movie movie = new Movie();
                            movie.setId(position + 1);
                            db.movieDao().delete(movie);
                            list.remove(position);
                        }
                    }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            movieAdapter.notifyItemRemoved(position + 1);
                            movieAdapter.notifyItemRangeChanged(position, movieAdapter.getItemCount());
                            return;
                        }
                    }).show();
                }
            }
        };

        mItemTouchHelper = new ItemTouchHelper(simpleCallback);
        mItemTouchHelper.attachToRecyclerView(recyclerViewMovie);
        return rootView;
    }


    @Override
    public void onResume() {
        super.onResume();
        updateMovie();
        getTopRatedMovies();
    }

    private void updateMovie() {

        swipeRefreshLayout.setRefreshing(false);
        db = Room.databaseBuilder(getActivity().getApplicationContext(), AppDatabase.class, "movie_and_song")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
        list = db.movieDao().getAllMovie();

       MovieServer movieServer = new MovieServer();
        for (Movie oneMovie : list){
            movieServer.setTitle(oneMovie.getName());
            movieServer.setOverview(oneMovie.getDescription());

            localData.add(movieServer);
        }
    }
    public void getTopRatedMovies(){

        movieApiService.getTopRatedMovies(API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MovieResponseServer>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "In onComplete()");
                        movieAdapter.setMovies(localData);
                        movieAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "In on Error()");
                        movieAdapter.setMovies(localData);
                        movieAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onNext(MovieResponseServer movieResponse) {
                        Log.d(TAG, "In onNext()");


                        List<MovieServer> completeList = movieResponse.getResults();

                        localData.addAll(completeList);


                    }
                });
    }
}

