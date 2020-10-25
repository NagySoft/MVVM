package com.essence.mvvmapplication.domain;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static String BASE_URL = "http://jsonplaceholder.typicode.com/";
    private static PostsServices postsServices;
    private static Retrofit INSTANCE;

    private static Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private static Retrofit getInstance() {
        if (INSTANCE == null)
            INSTANCE = getRetrofit();
        return INSTANCE;
    }

    public static PostsServices getPostsServices() {
        if (postsServices == null)
            postsServices = getInstance().create(PostsServices.class);
        return postsServices;
    }
}
