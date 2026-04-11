package com.example.atividade_dm2_retrofit_client;

import com.google.gson.annotations.SerializedName;

public class Issue {
    private Long id;
    private String title;
    private int number;
    private String body;
    private String state;
    private int comments;
    private String created_at;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getNumber() {
        return number;
    }

    public String getBody() {
        return body;
    }

    public String getState() {
        return state;
    }

    public int getComments() {
        return comments;
    }

    public String getCreatedAt() {
        return created_at;
    }
}
