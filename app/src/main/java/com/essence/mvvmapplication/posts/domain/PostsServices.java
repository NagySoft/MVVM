package com.essence.mvvmapplication.posts.domain;

import com.essence.mvvmapplication.posts.model.PostModel;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface PostsServices {
    @GET("posts")
    Observable<List<PostModel>> getPosts();
}