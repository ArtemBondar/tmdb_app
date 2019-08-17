package com.github.artembondar.tmdbapp;

import android.os.Bundle;
import android.util.Log;

import androidx.fragment.app.FragmentActivity;

import com.github.artembondar.tmdbapp.app.TmdbApplication;
import com.github.artembondar.tmdbapp.data.Movie;
import com.github.artembondar.tmdbapp.data.MovieVideos;
import com.github.artembondar.tmdbapp.data.UpcomingMovies;
import com.github.artembondar.tmdbapp.retrofit.TmdbApiInterface;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends FragmentActivity {

    public static final String TAG = MainActivity.class.getCanonicalName();
    private TmdbApiInterface tmdbApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tmdbApiInterface = TmdbApplication.get().getApplicationComponent().getTmdbApiInterface();
    }

    @Override
    protected void onStart() {
        super.onStart();
        testApi();
    }

    private void testApi() {
        tmdbApiInterface.getUpcomingMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<UpcomingMovies>() {
                    @Override
                    public void onNext(UpcomingMovies upcomingMovies) {
                        Log.d(TAG, "onNext: " + upcomingMovies);
                        if (upcomingMovies != null) {
                            Log.d(TAG, "onNext: Got upcoming movies: " + upcomingMovies.movies.size());
                            if (!upcomingMovies.movies.isEmpty()) {
                                tmdbApiInterface.getMovieDetails(upcomingMovies.movies.get(0).id)
                                        .subscribeOn(Schedulers.io())
                                        .observeOn(AndroidSchedulers.mainThread())
                                        .subscribe(new DisposableObserver<Movie>() {
                                            @Override
                                            public void onNext(Movie movie) {
                                                Log.d(TAG, "onNext: Got movie details: " + movie);
                                            }

                                            @Override
                                            public void onError(Throwable e) {
                                                Log.e(TAG, "onError: Got movie details", e);
                                            }

                                            @Override
                                            public void onComplete() {
                                                Log.d(TAG, "onComplete: Got movie details");
                                            }
                                        });

                                tmdbApiInterface.getMovieVideos(upcomingMovies.movies.get(0).id)
                                        .subscribeOn(Schedulers.io())
                                        .observeOn(AndroidSchedulers.mainThread())
                                        .subscribe(new DisposableObserver<MovieVideos>() {
                                            @Override
                                            public void onNext(MovieVideos movieVideos) {
                                                Log.d(TAG, "onNext: Got movie videos: " + movieVideos);
                                            }

                                            @Override
                                            public void onError(Throwable e) {
                                                Log.e(TAG, "onError: Got movie videos", e);
                                            }

                                            @Override
                                            public void onComplete() {
                                                Log.d(TAG, "onComplete: Got movie videos");
                                            }
                                        });
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + e);
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: ");
                    }
                });
    }
}
