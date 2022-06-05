package com.aca.homework.week21.post.service.impl;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {

    private static Retrofit retrofit = null;

    public static Retrofit valueOff() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().
                    baseUrl("https://catfact.ninja/").
                    addConverterFactory(GsonConverterFactory.create()).
                    build();
        }
        return retrofit;
    }
}
