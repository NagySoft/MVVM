package com.essence.mvvmapplication.posts.ui.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.essence.mvvmapplication.di.post.PostScope;
import com.essence.mvvmapplication.posts.domain.PostsRepository;
import com.essence.mvvmapplication.posts.model.PostModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

@PostScope
public class PostsViewModel extends ViewModel {
    private static final String TAG = PostsViewModel.class.getSimpleName();

    @Inject
    PostsRepository postsRepository;

    private MutableLiveData<List<PostModel>> liveData;

    @Inject
    public PostsViewModel() {
        liveData = new MutableLiveData<>();
    }

    public void getPost() {
        postsRepository.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(postModels -> liveData.setValue(postModels),
                        throwable -> Log.e(TAG, "PostsViewModel: ", throwable));
    }

    public MutableLiveData<List<PostModel>> getLiveData() {
        return liveData;
    }
}