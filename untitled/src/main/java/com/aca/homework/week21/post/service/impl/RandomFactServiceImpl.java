package com.aca.homework.week21.post.service.impl;

import com.aca.homework.week21.post.dto.CatFactDto;
import com.aca.homework.week21.post.service.core.CatFactService;
import com.aca.homework.week21.post.service.core.RandomFactService;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

@Service
public class RandomFactServiceImpl implements RandomFactService {

    @Override
    public String getRandomFact() {
        CatFactService catFactService = RetrofitFactory.valueOff().create(CatFactService.class);
        Call<CatFactDto> catFact = catFactService.getFactDto();
        Response<CatFactDto> response;
        try {
            response = catFact.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response.body().getFact();
    }
}
