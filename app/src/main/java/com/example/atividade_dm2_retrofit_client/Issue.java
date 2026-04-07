package com.example.atividade_dm2_retrofit_client;

public class Issue {
    private int id;
    private String title;
    private String body;
    private String state;
    private int comments;
    private String createdAt;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
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
        return createdAt;
    }
}
