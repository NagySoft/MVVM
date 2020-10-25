package com.essence.mvvmapplication.model;

public class PostModel {
    private int id;
    private String title;
    private String body;
    private int userId;

    public PostModel(int id, int userId, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public int getUserId() {
        return userId;
    }
}
