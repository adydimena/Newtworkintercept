package com.example.ady.newtworkintercept.AuxUtility;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ady on 11/20/2017.
 */

public class NetworkUtilitty {

    public static Retrofit configureRetrofitClient(String BASE_URL) {
        // Set custom okhttpclient to retrofit instance
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(configureHttClient(configureIntercepor()))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private static OkHttpClient configureHttClient(HttpLoggingInterceptor interceptor) {
        // Set interceptor to custom okhttpclient
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
    }

    private static HttpLoggingInterceptor configureIntercepor() {
        // Create and configure network interceptor
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

        interceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);

        return interceptor;
    }
}

