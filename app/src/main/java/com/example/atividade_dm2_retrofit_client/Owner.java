package com.example.atividade_dm2_retrofit_client;

import com.google.gson.annotations.SerializedName;

public class Owner extends User {
    @SerializedName("name")
    private String name;

    public Owner(String login, String avatarUrl, String htmlUrl, String name) {
        super(login, avatarUrl, htmlUrl);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
