package com.github.artembondar.tmdbapp.dagger.module;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.github.artembondar.tmdbapp.dagger.ApplicationScope;
import com.github.artembondar.tmdbapp.retrofit.TmdbApiInterface;
import com.github.artembondar.tmdbapp.retrofit.TmdbApiKeyInterceptor;
import com.github.artembondar.tmdbapp.utils.Constants;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitModule {

    @Provides
    @ApplicationScope
    TmdbApiInterface provideTmdbApiInterface(Retrofit retroFit) {
        return retroFit.create(TmdbApiInterface.class);
    }

    @Provides
    @ApplicationScope
    Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(Constants.TMDB_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Provides
    @ApplicationScope
    OkHttpClient provideOkHttpClient(Interceptor interceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addNetworkInterceptor(new StethoInterceptor())
                .build();
    }

    @Provides
    @ApplicationScope
    Interceptor provideInterceptor() {
        return new TmdbApiKeyInterceptor();
    }
}
