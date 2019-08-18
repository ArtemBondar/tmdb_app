package com.github.artembondar.tmdbapp.retrofit.data;

import com.google.gson.annotations.SerializedName;

public class ReducedMovie {

    @SerializedName("poster_path")
    public String posterImagePath;

    @SerializedName("backdrop_path")
    public String backdropImagePath;

    @SerializedName("title")
    public String title;

    @SerializedName("id")
    public int id;

    @SerializedName("release_date")
    public String releaseDate;

    @Override
    public String toString() {
        return "ReducedMovie{" +
                "posterImagePath='" + posterImagePath + '\'' +
                ", backdropImagePath='" + backdropImagePath + '\'' +
                ", title='" + title + '\'' +
                ", id=" + id +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }
}
