package com.example.ady.newtworkintercept.AuxUtility;

import com.example.ady.newtworkintercept.Model.RandomResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Ady on 11/20/2017.
 */

public class RetrofitHelper {

    public static final String BASE_URL = "https://randomuser.me/";

    //    build the retrofit object to be used
    public static Retrofit create() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;

    }

    //call the interface to get the response
    public static Call<RandomResponse> getRandomresponse(){
        Retrofit retrofit = create();
        RetrofitService service = retrofit.create(RetrofitService.class);
        return service.getRandomresponse();
    }


    //    create an interface for http verbs
    interface RetrofitService {

        @GET("api/?results=10")
        Call<RandomResponse> getRandomresponse();
    }


}
