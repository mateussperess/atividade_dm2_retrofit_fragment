package com.example.atividade_dm2_retrofit_client;

import com.google.gson.annotations.SerializedName;

public class Owner extends User {
    @SerializedName("name")
    private String name;

    public String getName() {
        return name;
    }
}
