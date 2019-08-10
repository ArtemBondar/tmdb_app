package com.github.artembondar.tmdbapp.dagger.component;

import com.github.artembondar.tmdbapp.dagger.ApplicationScope;
import com.github.artembondar.tmdbapp.dagger.module.RetrofitModule;
import com.github.artembondar.tmdbapp.retrofit.TmdbApiInterface;

import dagger.Component;
@ApplicationScope
@Component(modules = RetrofitModule.class)
public interface ApplicationComponent {

    TmdbApiInterface getTmdbApiInterface();
}
