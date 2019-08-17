package com.github.artembondar.tmdbapp.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UpcomingMovies {

    @SerializedName("page")
    public int page;

    @SerializedName("results")
    public List<ReducedMovie> movies;

    @Override
    public String toString() {
        return "UpcomingMovies{" +
                "page=" + page +
                ", movies=" + movies +
                '}';
    }
}
