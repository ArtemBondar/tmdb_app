package com.github.artembondar.tmdbapp.ui.upcoming.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.artembondar.tmdbapp.R;
import com.github.artembondar.tmdbapp.retrofit.data.UpcomingMovies;
import com.github.artembondar.tmdbapp.ui.upcoming.UpcomingMoviesContract;
import com.github.artembondar.tmdbapp.ui.upcoming.adapter.UpcomingMoviesAdapter;
import com.github.artembondar.tmdbapp.ui.upcoming.interactor.UpcomingMoviesInteractor;
import com.github.artembondar.tmdbapp.ui.upcoming.presenter.UpcomingMoviesPresenter;

public class UpcomingMoviesFragment extends Fragment implements UpcomingMoviesContract.View {

    public static final String TAG = UpcomingMoviesFragment.class.getCanonicalName();

    private UpcomingMoviesPresenter upcomingMoviesPresenter;

    private RecyclerView upcomingMoviesRecyclerView;

    private UpcomingMoviesAdapter upcomingMoviesAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.upcomingMoviesPresenter = new UpcomingMoviesPresenter(this, new UpcomingMoviesInteractor());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.upcoming_movies, container, false);
        upcomingMoviesRecyclerView = rootView.findViewById(R.id.upcoming_movies_recycler_view);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        upcomingMoviesAdapter = new UpcomingMoviesAdapter();
        upcomingMoviesRecyclerView.setAdapter(upcomingMoviesAdapter);
        upcomingMoviesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onStart() {
        super.onStart();
        upcomingMoviesPresenter.loadUpcomingMovies();
    }

    @Override
    public void onStop() {
        super.onStop();
        upcomingMoviesPresenter.release();
    }

    @Override
    public void showUpcomingMovies(UpcomingMovies upcomingMovies) {
        if (upcomingMoviesRecyclerView != null) {
            upcomingMoviesAdapter.setMovies(upcomingMovies.movies);
        }
    }

    @Override
    public void onUpcomingMoviesLoadFail(Throwable t) {

    }
}
