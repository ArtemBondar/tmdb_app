package com.github.artembondar.tmdbapp.retrofit.data;

import com.google.gson.annotations.SerializedName;

public class SpokenLanguage {

    @SerializedName("iso_639_1")
    public String iso_639_1;

    @SerializedName("name")
    public String name;

    @Override
    public String toString() {
        return "SpokenLanguage{" +
                "iso_639_1='" + iso_639_1 + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
