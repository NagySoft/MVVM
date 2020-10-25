package com.essence.mvvmapplication.ui.posts.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.essence.mvvmapplication.R;
import com.essence.mvvmapplication.databinding.ActivityMainBinding;
import com.essence.mvvmapplication.model.PostModel;
import com.essence.mvvmapplication.ui.posts.viewmodel.PostsViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private List<PostModel> postModels;
    private PostsViewModel postsViewModel;
    private PostsAdapter postsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        postModels = new ArrayList<>();
        postsAdapter = new PostsAdapter(postModels);
        binding.recyclerView.setAdapter(postsAdapter);

        postsViewModel = new ViewModelProvider(this).get(PostsViewModel.class);
        postsViewModel.getLiveData().observe(this, posts -> {
            this.postModels.clear();
            this.postModels.addAll(posts);
            postsAdapter.notifyDataSetChanged();
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}