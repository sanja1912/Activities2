package com.example.dev7.activities2;

import java.io.Serializable;

/**
 * Created by dev7 on 7.11.17..
 */

public class ListOfMovies implements Serializable{
    private String header;
    private String description;
    private int image;

    public ListOfMovies(){



    }

    public ListOfMovies(String header, String description, int image) {
        this.header = header;
        this.description = description;
        this.image = image;
    }

    public String getHeader() {
        return header;
    }

    public String getDescription() {
        return description;
    }

    public int getImage() {
        return image;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
