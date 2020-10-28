package com.essence.mvvmapplication.di;

import com.essence.mvvmapplication.posts.domain.PostsServices;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {
    private static String BASE_URL = "http://jsonplaceholder.typicode.com/";

    @Provides
    @Singleton
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    PostsServices providePostsServices() {
        return provideRetrofit().create(PostsServices.class);
    }
}