package com.example.atividade_dm2_retrofit_client;

public class Repo {
    private Long id;
    private String name;
    private String full_name;
    private String description;
    private String url;
    private Owner owner;

    public Repo(Long id, String name, String full_name, String description, String url) {
        this.id = id;
        this.name = name;
        this.full_name = full_name;
        this.description = description;
        this.url = url;
    }

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
