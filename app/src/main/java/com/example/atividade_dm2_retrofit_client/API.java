package com.example.atividade_dm2_retrofit_client;

import androidx.annotation.NonNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface API {
    String BASE_URL = "https://api.github.com/";

//    @GET("users/torvalds/repos") // TODO: mudar dps
//    Call<List<Repo>> getUserRepos();

    @GET("users/{username}/repos")
    @NonNull
    Call <List<Repo>> getUserRepos(@Path("username") String username);

    @GET("users/{username}")
    Call<Owner> getOwnerByUsername(@Path("username") String username);
}
