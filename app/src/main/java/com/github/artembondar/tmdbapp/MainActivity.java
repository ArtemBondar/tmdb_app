package com.github.artembondar.tmdbapp;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;
import com.github.artembondar.tmdbapp.ui.upcoming.view.UpcomingMoviesFragment;


public class MainActivity extends FragmentActivity {

    public static final String TAG = MainActivity.class.getCanonicalName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        showUpcomingMoviesFragment();
    }

    private void showUpcomingMoviesFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new UpcomingMoviesFragment(), UpcomingMoviesFragment.TAG)
                .commit();
    }
}
