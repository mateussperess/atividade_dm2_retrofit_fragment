package com.example.atividade_dm2_retrofit_client;

import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RetrofitClient instance = null;
    private API api;

    private RetrofitClient() {

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(chain -> {
                    Request request = chain.request();
//                    Log.d("HTTP_URL", request.url().toString());
                    return chain.proceed(request);
                })
                .addInterceptor(chain -> {
                    Request request = chain.request().newBuilder()
                            .addHeader("Authorization", "Bearer " + BuildConfig.GITHUB_TOKEN)
                            .build();
                    return chain.proceed(request);
                })
//                .addInterceptor(new okhttp3.logging.HttpLoggingInterceptor(msg ->
//                        Log.d("HTTP_BODY", msg))
//                        .setLevel(okhttp3.logging.HttpLoggingInterceptor.Level.BODY))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(API.class);
    }

    public static synchronized RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }

    public API getMyApi() {
        return api;
    }
}
