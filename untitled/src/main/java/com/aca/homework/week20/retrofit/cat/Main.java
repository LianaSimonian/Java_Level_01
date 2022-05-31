package com.aca.homework.week20.retrofit.cat;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl("https://catfact.ninja/").
                addConverterFactory(GsonConverterFactory.create()).
                build();

        CatFactService catFactService = retrofit.create(CatFactService.class);

        Call<CatFactDto> catFact = catFactService.getFactDto();
        Response<CatFactDto> response;
        try {
            response = catFact.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("response of request: " + response.body());
    }
}