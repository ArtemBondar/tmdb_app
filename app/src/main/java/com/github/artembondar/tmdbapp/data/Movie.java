package com.github.artembondar.tmdbapp.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movie extends ReducedMovie {

    @SerializedName("overview")
    public String overview;

    @SerializedName("vote_average")
    public float averageVote;

    @SerializedName("genres")
    public List<Genre> genres;

    @SerializedName("budget")
    public int budget;

    @SerializedName("spoken_languages")
    public List<SpokenLanguage> spokenLanguages;

    @Override
    public String toString() {
        return "Movie{" +
                "overview='" + overview + '\'' +
                ", averageVote=" + averageVote +
                ", genres=" + genres +
                ", budget=" + budget +
                ", spokenLanguages=" + spokenLanguages +
                ", posterImagePath='" + posterImagePath + '\'' +
                ", title='" + title + '\'' +
                ", id=" + id +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }
}
