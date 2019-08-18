package com.github.artembondar.tmdbapp.utils;

public class Constants {

    Constants() {
    }

    /**
     * TMDB API key parameter name, used to pass one to interceptor
     */
    public static final String API_KEY_PARAMETER_NAME = "api_key";
    /**
     * TMDB API key value
     */
    public static final String TMDB_API_KEY = "4019d14f1775a3f6fe23f3b065fca63c";
    /**
     * TMDB API base URL
     */
    public static final String TMDB_API_BASE_URL = "https://api.themoviedb.org/3/";
    /**
     * TMDB API image base URL
     */
    //TODO Check how to do image size configurable (https://developers.themoviedb.org/3/configuration/get-api-configuration)
    public static final String TMDB_IMAGE_BASE_URL = "https://image.tmdb.org/t/p/";
}
