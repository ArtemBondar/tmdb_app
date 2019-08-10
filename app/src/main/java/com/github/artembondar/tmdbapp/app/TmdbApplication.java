package com.github.artembondar.tmdbapp.app;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.github.artembondar.tmdbapp.dagger.component.ApplicationComponent;
import com.github.artembondar.tmdbapp.dagger.component.DaggerApplicationComponent;

public class TmdbApplication extends Application {

    private static TmdbApplication instance;

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Stetho.initializeWithDefaults(this);
        applicationComponent = DaggerApplicationComponent.builder().build();
    }


    public static TmdbApplication get() {
        return instance;
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
