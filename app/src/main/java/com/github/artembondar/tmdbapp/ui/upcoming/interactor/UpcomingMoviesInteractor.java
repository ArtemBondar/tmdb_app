package com.github.artembondar.tmdbapp.ui.upcoming.interactor;

import android.util.Log;

import androidx.annotation.NonNull;

import com.github.artembondar.tmdbapp.app.TmdbApplication;
import com.github.artembondar.tmdbapp.retrofit.TmdbApiInterface;
import com.github.artembondar.tmdbapp.retrofit.data.UpcomingMovies;
import com.github.artembondar.tmdbapp.ui.upcoming.UpcomingMoviesContract;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class UpcomingMoviesInteractor implements UpcomingMoviesContract.Interactor {

    public static final String TAG = UpcomingMoviesInteractor.class.getCanonicalName();

    private TmdbApiInterface tmdbApiInterface;

    private Disposable upcomingMoviesDisposable;

    public UpcomingMoviesInteractor() {
        this.tmdbApiInterface = TmdbApplication.get().getApplicationComponent().getTmdbApiInterface();
    }

    @Override
    public void loadUpcomingMovies(@NonNull final UpcomingMoviesContract.UpcomingMoviesLoadActionListener upcomingMoviesLoadActionListener) {
        upcomingMoviesDisposable = tmdbApiInterface.getUpcomingMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                //TODO Check how to use subscribe with disposable?
                .subscribeWith(new DisposableObserver<UpcomingMovies>() {
                    @Override
                    public void onNext(UpcomingMovies upcomingMovies) {
                        Log.d(TAG, "Got upcoming movies: " + upcomingMovies.movies.size());
                        upcomingMoviesLoadActionListener.onLoadSuccess(upcomingMovies);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "An error occurred on loading upcoming movies.", e);
                        upcomingMoviesLoadActionListener.onLoadFail(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void release() {
        if (upcomingMoviesDisposable != null && !upcomingMoviesDisposable.isDisposed()) {
            upcomingMoviesDisposable.dispose();
        }
    }
}
