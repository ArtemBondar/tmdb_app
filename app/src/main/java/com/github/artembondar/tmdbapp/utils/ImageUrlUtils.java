package com.github.artembondar.tmdbapp.utils;

public class ImageUrlUtils {

    ImageUrlUtils() {
    }

    public static String getBackdropImageUrl(BackdropImageSize backdropImageSize, String backdropPath) {
        return buildImageUrl(backdropImageSize.name().toLowerCase(), backdropPath);
    }

    public static String getPosterImageUrl(PosterImageSize posterImageSize, String posterPath) {
        return buildImageUrl(posterImageSize.name().toLowerCase(), posterPath);
    }

    private static String buildImageUrl(String imageSize, String imagePath) {
        return Constants.TMDB_IMAGE_BASE_URL + imageSize + imagePath;
    }

    public enum BackdropImageSize {
        W300,
        W780,
        W1280,
        ORIGINAL
    }

    public enum PosterImageSize {
        W92,
        W154,
        W185,
        W342,
        W500,
        W780,
        ORIGINAL
    }
}
