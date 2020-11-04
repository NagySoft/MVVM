package com.essence.mvvmapplication.posts.domain;

import com.essence.mvvmapplication.posts.model.PostModel;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.rxjava3.core.Observable;

@Singleton
public class PostsRepository {
    private static final String TAG = PostsRepository.class.getSimpleName();

    @Inject
    PostsServices postsServices;

    @Inject
    public PostsRepository() {
    }

    public Observable<List<PostModel>> getPosts() {
        return postsServices.getPosts();
    }
}