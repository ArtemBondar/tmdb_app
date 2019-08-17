package com.github.artembondar.tmdbapp.retrofit;

import com.github.artembondar.tmdbapp.data.Movie;
import com.github.artembondar.tmdbapp.data.MovieVideos;
import com.github.artembondar.tmdbapp.data.UpcomingMovies;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TmdbApiInterface {

    @GET("movie/upcoming")
    Observable<UpcomingMovies> getUpcomingMovies(@Query("language") String language, @Query("page") int page, @Query("region") String region);

    @GET("movie/upcoming")
    Observable<UpcomingMovies> getUpcomingMovies(@Query("language") String language, @Query("page") int page);

    @GET("movie/upcoming")
    Observable<UpcomingMovies> getUpcomingMovies(@Query("language") String language);

    @GET("movie/upcoming")
    Observable<UpcomingMovies> getUpcomingMovies();

    @GET("movie/{movieId}")
    Observable<Movie> getMovieDetails(@Path("movieId") int movieId);

    @GET("movie/{movieId}/videos")
    Observable<MovieVideos> getMovieVideos(@Path("movieId") int movieId);

    @GET("movie/{movieId}/videos")
    Observable<MovieVideos> getMovieVideos(@Path("movieId") int movieId, @Query("language") String iso_639_1_language);
}
