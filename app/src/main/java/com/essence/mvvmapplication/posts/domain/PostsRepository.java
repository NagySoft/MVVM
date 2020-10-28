package com.essence.mvvmapplication.posts.domain;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.essence.mvvmapplication.posts.model.PostModel;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class PostsRepository {
    private static final String TAG = PostsRepository.class.getSimpleName();

    @Inject
    PostsServices postsServices;

    @Inject
    public PostsRepository() {
    }

    public MutableLiveData<List<PostModel>> getPosts() {
        MutableLiveData<List<PostModel>> liveData = new MutableLiveData<>();
        postsServices.getPosts().enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                liveData.setValue(response.body());
                Log.d(TAG, "onResponse: " + response.body().toArray().toString());
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable throwable) {
                Log.e(TAG, "onFailure: ", throwable);
            }
        });
        return liveData;
    }
}