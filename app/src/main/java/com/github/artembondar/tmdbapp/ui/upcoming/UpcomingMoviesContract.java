package com.github.artembondar.tmdbapp.ui.upcoming;

import androidx.annotation.NonNull;

import com.github.artembondar.tmdbapp.retrofit.data.Movie;
import com.github.artembondar.tmdbapp.retrofit.data.UpcomingMovies;

public interface UpcomingMoviesContract {

    interface View {

        void showUpcomingMovies(UpcomingMovies upcomingMovies);

        void onUpcomingMoviesLoadFail(Throwable t);
    }

    interface Presenter {

        void loadUpcomingMovies();

        void onMovieItemClicked(Movie movie);

        void release();
    }

    interface Interactor {

        void loadUpcomingMovies(@NonNull UpcomingMoviesLoadActionListener upcomingMoviesLoadActionListener);

        void release();
    }

    //Listener
    interface UpcomingMoviesLoadActionListener {

        void onLoadSuccess(UpcomingMovies upcomingMovies);

        void onLoadFail(Throwable t);
    }
}
