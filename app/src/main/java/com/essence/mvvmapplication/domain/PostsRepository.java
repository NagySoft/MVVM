package com.essence.mvvmapplication.domain;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.essence.mvvmapplication.model.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsRepository {
    private static final String TAG = PostsRepository.class.getSimpleName();

    public PostsRepository() {
    }

    public MutableLiveData<List<PostModel>> getPosts() {
        MutableLiveData<List<PostModel>> liveData = new MutableLiveData<>();
        ApiClient.getPostsServices().getPosts().enqueue(new Callback<List<PostModel>>() {
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