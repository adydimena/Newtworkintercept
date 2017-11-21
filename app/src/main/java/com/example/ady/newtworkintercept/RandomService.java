package com.example.ady.newtworkintercept;

import com.example.ady.newtworkintercept.Model.RandomResponse;

import retrofit2.http.GET;
import retrofit2.Call;

/**
 * Created by Ady on 11/20/2017.
 */

public interface RandomService {
    @GET("api")
    Call<RandomResponse> getRandomUser();



}
