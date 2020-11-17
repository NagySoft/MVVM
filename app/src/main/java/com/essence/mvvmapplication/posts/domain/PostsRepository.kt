package com.essence.mvvmapplication.posts.domain

import com.essence.mvvmapplication.posts.model.PostModel
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostsRepository @Inject constructor() {
    @JvmField
    @Inject
    var postsServices: PostsServices? = null
    val posts: Observable<List<PostModel?>?>?
        get() = postsServices!!.posts

    companion object {
        private val TAG = PostsRepository::class.java.simpleName
    }
}