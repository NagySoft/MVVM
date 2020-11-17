package com.essence.mvvmapplication.di.post

import com.essence.mvvmapplication.posts.ui.view.PostsActivity
import dagger.Subcomponent

@Subcomponent
@PostScope
interface PostComponent {
    @Subcomponent.Builder
    interface Builder {
        fun create(): PostComponent?
    }

    fun inject(postsActivity: PostsActivity?)
}