package com.aca.homework.week21.post.service.core;

import com.aca.homework.week21.post.dto.CatFactDto;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CatFactService {

    @GET("fact")
    Call<CatFactDto> getFactDto();
}