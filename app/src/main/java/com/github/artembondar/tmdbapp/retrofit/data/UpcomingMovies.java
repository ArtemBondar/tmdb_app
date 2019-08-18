package com.github.artembondar.tmdbapp.retrofit.data;

import com.google.gson.annotations.SerializedName;

import java.util.Collections;
import java.util.List;

public class UpcomingMovies {

    @SerializedName("page")
    public int page;

    @SerializedName("results")
    public List<Movie> movies = Collections.emptyList();

    @Override
    public String toString() {
        return "UpcomingMovies{" +
                "page=" + page +
                ", movies=" + movies +
                '}';
    }
}
