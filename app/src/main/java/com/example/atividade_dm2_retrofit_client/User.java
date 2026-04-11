package com.example.atividade_dm2_retrofit_client;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("login")
    private String login;
    @SerializedName("avatar_url")

    private String avatarUrl;
    @SerializedName("html_url")

    private String htmlUrl;

//    public User(String login, String avatarUrl, String htmlUrl) {}

    public String getLogin() {
        return login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }
}
