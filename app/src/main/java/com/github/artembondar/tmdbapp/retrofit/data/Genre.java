package com.github.artembondar.tmdbapp.retrofit.data;

import com.google.gson.annotations.SerializedName;

public class Genre {

    @SerializedName("id")
    public int id;

    @SerializedName("name")
    public String name;

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
