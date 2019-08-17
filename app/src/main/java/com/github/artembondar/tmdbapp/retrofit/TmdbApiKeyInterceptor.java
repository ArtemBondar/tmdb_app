package com.github.artembondar.tmdbapp.retrofit;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import static com.github.artembondar.tmdbapp.utils.Constants.API_KEY_PARAMETER_NAME;
import static com.github.artembondar.tmdbapp.utils.Constants.TMDB_API_KEY;

/**
 * Add to each request TMDB API key
 */
public class TmdbApiKeyInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        HttpUrl originalHttpUrl = original.url
                ();

        HttpUrl url = originalHttpUrl.newBuilder()
                .addQueryParameter(API_KEY_PARAMETER_NAME, TMDB_API_KEY)
                .build();

        // Request customization: add request headers
        Request.Builder requestBuilder = original.newBuilder()
                .url(url);

        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}
