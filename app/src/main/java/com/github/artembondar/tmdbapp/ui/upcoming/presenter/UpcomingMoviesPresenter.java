package com.github.artembondar.tmdbapp.ui.upcoming.presenter;

import androidx.annotation.NonNull;

import com.github.artembondar.tmdbapp.retrofit.data.Movie;
import com.github.artembondar.tmdbapp.retrofit.data.UpcomingMovies;
import com.github.artembondar.tmdbapp.ui.upcoming.UpcomingMoviesContract;

import java.lang.ref.WeakReference;

public class UpcomingMoviesPresenter implements UpcomingMoviesContract.Presenter {


    private WeakReference<UpcomingMoviesContract.View> viewWeakReference;

    private UpcomingMoviesContract.Interactor interactor;

    public UpcomingMoviesPresenter(@NonNull UpcomingMoviesContract.View view, @NonNull UpcomingMoviesContract.Interactor interactor) {
        this.viewWeakReference = new WeakReference<>(view);
        this.interactor = interactor;
    }

    @Override
    public void loadUpcomingMovies() {
        final UpcomingMoviesContract.View view = viewWeakReference.get();
        if (view == null) {
            return;
        }

        interactor.loadUpcomingMovies(new UpcomingMoviesContract.UpcomingMoviesLoadActionListener() {
            @Override
            public void onLoadSuccess(UpcomingMovies upcomingMovies) {
                view.showUpcomingMovies(upcomingMovies);
            }

            @Override
            public void onLoadFail(Throwable t) {
                view.onUpcomingMoviesLoadFail(t);
            }
        });
    }

    @Override
    public void onMovieItemClicked(Movie movie) {

    }

    @Override
    public void release() {
        interactor.release();
    }
}
