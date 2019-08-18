package com.github.artembondar.tmdbapp.retrofit.data;

import com.google.gson.annotations.SerializedName;

import java.util.Collections;
import java.util.List;

public class MovieVideos {

    @SerializedName("id")
    public String movieId;

    @SerializedName("results")
    public List<Video> videos = Collections.emptyList();

    @Override
    public String toString() {
        return "MovieVideos{" +
                "movieId='" + movieId + '\'' +
                ", videos=" + videos +
                '}';
    }
}
