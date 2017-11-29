package com.example.dev7.activities2;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import java.io.Serializable;


/**
 * Created by dev7 on 28.11.17..
 */
@Entity
public class Movie implements Serializable{
    private static final long serialVersionUID = 1L;

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name="name")
    public String name;

    @ColumnInfo(name="description")
    public String description;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
