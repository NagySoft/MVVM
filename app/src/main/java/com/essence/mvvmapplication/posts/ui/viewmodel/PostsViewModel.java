package com.essence.mvvmapplication.posts.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.essence.mvvmapplication.di.post.PostScope;
import com.essence.mvvmapplication.posts.domain.PostsRepository;
import com.essence.mvvmapplication.posts.model.PostModel;

import java.util.List;

import javax.inject.Inject;

@PostScope
public class PostsViewModel extends ViewModel {
    private static final String TAG = PostsViewModel.class.getSimpleName();

    private MutableLiveData<List<PostModel>> liveData;

    @Inject
    public PostsViewModel(PostsRepository postsRepository) {
        liveData = postsRepository.getPosts();
    }

    public MutableLiveData<List<PostModel>> getLiveData() {
        return liveData;
    }
}