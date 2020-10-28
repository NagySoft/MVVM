package com.essence.mvvmapplication.di.post;

import com.essence.mvvmapplication.posts.ui.view.PostsActivity;

import dagger.Subcomponent;

@Subcomponent
@PostScope
public interface PostComponent {
    @Subcomponent.Builder
    interface Builder {
        PostComponent create();
    }

    void inject(PostsActivity postsActivity);
}
