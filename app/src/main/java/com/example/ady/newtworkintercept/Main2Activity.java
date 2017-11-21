package com.example.ady.newtworkintercept;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ady.newtworkintercept.AuxUtility.NetworkUtilitty;
import com.example.ady.newtworkintercept.Model.RandomResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Main2Activity extends AppCompatActivity {
    Retrofit retrofit;
    RandomService randomService;
    private TextView fname;
    private TextView lname;
    private TextView fullname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        retrofit = NetworkUtilitty.configureRetrofitClient("https://randomuser.me/");
        randomService = retrofit.create(RandomService.class);
        randomService.getRandomUser().enqueue(new Callback<RandomResponse>() {
            @Override
            public void onResponse(Call<RandomResponse> call, Response<RandomResponse> response) {
                fname = findViewById(R.id.fname);
                lname = findViewById(R.id.lname);
                fullname = findViewById(R.id.fullname);
                ImageView image = findViewById(R.id.image);
                String first = response.body().getResults().get(0).getName().getFirst();
                String last = response.body().getResults().get(0).getName().getLast();
                String urlforimage = response.body().getResults().get(0).getPicture().getMedium();
                fname.setText("First Name: " + first);
                lname.setText("Last Name: " + last);
                fullname.setText("Full Name: " + first + " " +last);

                Glide.with(Main2Activity.this).load(urlforimage).into(image);


            }

            @Override
            public void onFailure(Call<RandomResponse> call, Throwable t) {


            }
        });
    }
}
