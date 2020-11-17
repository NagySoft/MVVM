package com.essence.mvvmapplication.posts.domain

import retrofit2.http.GET
import com.essence.mvvmapplication.posts.model.PostModel
import io.reactivex.rxjava3.core.Observable

interface PostsServices {
    @get:GET("posts")
    val posts: Observable<List<PostModel?>?>?
}