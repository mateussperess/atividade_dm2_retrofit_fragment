package com.example.atividade_dm2_retrofit_client;

import com.google.gson.annotations.SerializedName;

public class Repo {
    private Long id;
    private String name;

    private String full_name;
    private String description;
    private Owner owner;
    private String url;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public Owner getOwner() {
        return owner;
    }
}
