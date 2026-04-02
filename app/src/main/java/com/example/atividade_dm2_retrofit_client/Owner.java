package com.example.atividade_dm2_retrofit_client;

import com.google.gson.annotations.SerializedName;

public class Owner {
    @SerializedName("login")
    private String login;
    @SerializedName("avatar_url")
    private String avatarUrl;
    @SerializedName("html_url")
    private String html_url;
    @SerializedName("contributions")
    private int contributions;
    @SerializedName("bio")
    private String bio;
    @SerializedName("name")
    private String name;

    public Owner(String login, String avatarUrl, String html_url, int contributions, String bio, String name) {
        this.login = login;
        this.avatarUrl = avatarUrl;
        this.html_url = html_url;
        this.contributions = contributions;
        this.bio = bio;
        this.name = name;
    }

    public String getLogin() { return login; }
    public String getAvatarUrl() { return avatarUrl; }
    public String getUrl() { return html_url; }
    public int getContributions() { return contributions; }
    public String getBio() { return bio; }
    public String getName() { return name; }

}
