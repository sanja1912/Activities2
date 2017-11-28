package com.example.dev7.activities2;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by dev7 on 28.11.17..
 */
@Dao
public interface SongDao {
    @Query("SELECT * FROM song")
      List<Song> getAllSongs();

    @Insert
      void insertAll(Song...songs);

    @Update
    void updateAll(Song...songs);

}
