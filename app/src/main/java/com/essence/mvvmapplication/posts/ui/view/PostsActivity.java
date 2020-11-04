package com.essence.mvvmapplication.posts.ui.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.essence.mvvmapplication.R;
import com.essence.mvvmapplication.databinding.ActivityMainBinding;
import com.essence.mvvmapplication.posts.model.PostModel;
import com.essence.mvvmapplication.posts.ui.viewmodel.PostsViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import static com.essence.mvvmapplication.MVVMApplication.getApplicationComponent;

public class PostsActivity extends AppCompatActivity {
    private static final String TAG = PostsActivity.class.getSimpleName();

    @Inject
    PostsViewModel postsViewModel;

    private List<PostModel> postModels;
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

        getApplicationComponent().postsComponent().create().inject(this);
        postsViewModel.getLiveData().observe(this, posts -> {
            this.postModels.clear();
            this.postModels.addAll(posts);
            postsAdapter.notifyDataSetChanged();
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        postsViewModel.getPost();
    }
}