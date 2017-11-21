package com.example.ady.newtworkintercept;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ady.newtworkintercept.Model.RandomResponse;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName()+ "_TAG" ;
    Retrofit retrofir;
    RandomService randomService;
    private TextView trying;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        int howmany = 1;

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

        //logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();



            retrofir = new Retrofit.Builder()
                    .baseUrl("https://randomuser.me/?results=" + howmany + "/")
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        for (int i = 0; i < howmany ; i++) {
            randomService = retrofir.create(RandomService.class);
            randomService.getRandomUser().enqueue(new Callback<RandomResponse>() {
                @Override
                public void onResponse(Call<RandomResponse> call, Response<RandomResponse> response) {
                    if (response.isSuccessful()) {


                        trying.append("" + response.body().getResults().size());

                        trying.append("\n");
                        trying.append(response.body().getResults().get(0).getName().getFirst());
                        trying.append("\n");
                    } else {
                        trying.setText("Failed");
                    }
                }

                @Override
                public void onFailure(Call<RandomResponse> call, Throwable t) {
                    trying.setText("Failed");

                }
            });
        }
        */

    }


    public void DisplayOnerandomUser(View view) {
        Intent intent = new Intent(this,Main2Activity.class);
        startActivity(intent);
    }

    public void DisplayManyusers(View view) {
        Intent intent = new Intent(this,Main3Activity.class);
        startActivity(intent);
    }

    public void DisplayManyFemaleusers(View view) {
    }

    public void DisplayManyMaleusers(View view) {
    }
}
