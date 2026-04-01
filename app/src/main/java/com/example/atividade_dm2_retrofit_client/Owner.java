package com.example.atividade_dm2_retrofit_client;

import com.google.gson.annotations.SerializedName;

public class Owner {
    @SerializedName("login")
    private String login;
    @SerializedName("avatar_url")
    private String avatarUrl;
    @SerializedName("url")
    private String url;

    public Owner(String login, String avatarUrl, String url) {
        this.login = login;
        this.avatarUrl = avatarUrl;
        this.url = url;
    }

    public String getLogin() { return login; }
    public String getAvatarUrl() { return avatarUrl; }
    public String getUrl() { return url; }
}
