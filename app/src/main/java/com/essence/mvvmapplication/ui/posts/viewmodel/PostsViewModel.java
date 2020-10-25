package com.essence.mvvmapplication.ui.posts.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.essence.mvvmapplication.domain.PostsRepository;
import com.essence.mvvmapplication.model.PostModel;

import java.util.List;

public class PostsViewModel extends ViewModel {
    private static final String TAG = PostsViewModel.class.getSimpleName();

    private MutableLiveData<List<PostModel>> liveData;
    private PostsRepository postsRepository;

    public PostsViewModel() {
        postsRepository = new PostsRepository();
        liveData = postsRepository.getPosts();
    }

    public MutableLiveData<List<PostModel>> getLiveData() {
        return liveData;
    }
}