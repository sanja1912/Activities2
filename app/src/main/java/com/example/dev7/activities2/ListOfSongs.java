package com.example.dev7.activities2;

import java.io.Serializable;

/**
 * Created by dev7 on 14.11.17..
 */

public class ListOfSongs implements Serializable {
    private String song;
    private String singer;

    public ListOfSongs(){


    }
    public ListOfSongs(String song, String singer) {
        this.song = song;
        this.singer = singer;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }
}
