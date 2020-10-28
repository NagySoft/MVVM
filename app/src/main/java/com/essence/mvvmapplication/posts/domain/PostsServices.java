package com.essence.mvvmapplication.posts.domain;

import com.essence.mvvmapplication.posts.model.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostsServices {
    @GET("posts")
    Call<List<PostModel>> getPosts();
}