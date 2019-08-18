package com.github.artembondar.tmdbapp.ui.upcoming.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.github.artembondar.tmdbapp.R;
import com.github.artembondar.tmdbapp.retrofit.data.Movie;
import com.github.artembondar.tmdbapp.utils.ImageUrlUtils;

import java.util.Collections;
import java.util.List;


public class UpcomingMoviesAdapter extends RecyclerView.Adapter<UpcomingMoviesAdapter.UpcomingMoviesViewHolder> {

    private List<Movie> movies = Collections.emptyList();

    public UpcomingMoviesAdapter() {
    }

    @NonNull
    @Override
    public UpcomingMoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.upcoming_movie_item, parent, false);
        return new UpcomingMoviesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UpcomingMoviesViewHolder holder, int position) {
        holder.bind(movies.get(position));
    }

    @Override
    public int getItemCount() {
        return movies != null ? movies.size() : 0;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
        notifyDataSetChanged();
    }

    static class UpcomingMoviesViewHolder extends RecyclerView.ViewHolder {

        static final String TAG = UpcomingMoviesViewHolder.class.getCanonicalName();

        //TODO Add butterknife
        private ImageView backdropImageView;
        private TextView titleTextView;

        UpcomingMoviesViewHolder(@NonNull View itemView) {
            super(itemView);
            backdropImageView = itemView.findViewById(R.id.upcoming_movie_backdrop_image_view);
            titleTextView = itemView.findViewById(R.id.upcoming_movie_title_text_view);
        }

        void bind(Movie movie) {
            String imageUrl = ImageUrlUtils.getBackdropImageUrl(ImageUrlUtils.BackdropImageSize.W1280, movie.backdropImagePath);
            Log.d(TAG, "Image url: " + imageUrl);
            Glide.with(itemView.getContext())
                    .load(imageUrl)
                    .into(backdropImageView);
            titleTextView.setText(movie.title);
        }
    }
}

