package com.example.dev7.activities2;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by dev7 on 28.11.17..
 */
@Dao
public interface MovieDao {
    @Query("SELECT * FROM movie")
    List<Movie> getAllMovie();

    @Insert
      void insertAll(Movie...movies);

    @Update
      void updateAll(Movie...movie);

    @Delete
    void delete(Movie movie);
}
