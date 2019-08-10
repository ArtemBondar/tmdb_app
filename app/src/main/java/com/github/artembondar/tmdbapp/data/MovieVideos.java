package com.github.artembondar.tmdbapp.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieVideos {

    @SerializedName("id")
    public String movieId;

    @SerializedName("results")
    public List<Video> videos;

    @Override
    public String toString() {
        return "MovieVideos{" +
                "movieId='" + movieId + '\'' +
                ", videos=" + videos +
                '}';
    }
}
