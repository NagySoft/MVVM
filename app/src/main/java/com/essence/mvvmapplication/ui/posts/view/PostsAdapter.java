package com.essence.mvvmapplication.ui.posts.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.essence.mvvmapplication.model.PostModel;
import com.essence.mvvmapplication.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostHolder> {
    List<PostModel> items;

    public PostsAdapter(List<PostModel> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
        PostModel item = items.get(position);
        holder.titleTextView.setText(item.getTitle());
        holder.bodyTextView.setText(item.getBody());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class PostHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title_textview)
        TextView titleTextView;
        @BindView(R.id.body_textview)
        TextView bodyTextView;

        public PostHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}