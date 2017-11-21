package com.example.ady.newtworkintercept;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ady.newtworkintercept.AuxUtility.Item;
import com.example.ady.newtworkintercept.AuxUtility.NetworkUtilitty;
import com.example.ady.newtworkintercept.AuxUtility.RetrofitHelper;
import com.example.ady.newtworkintercept.Model.RandomResponse;
import com.example.ady.newtworkintercept.Model.Result;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Main3Activity extends AppCompatActivity {
    private static final String TAG = "Thread" ;
    Retrofit retrofit;
    RandomService randomService;
    List<Result> list;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView.ItemAnimator itemAnimator;
    private Recycleadapter recycleadapter;
    String[] out;
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        list = new ArrayList<>();
        retrofit = NetworkUtilitty.configureRetrofitClient("https://randomuser.me/");
        randomService = retrofit.create(RandomService.class);
        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message message) {
                recyclerView = findViewById(R.id.recycleMainLayout);
                linearLayoutManager = new LinearLayoutManager(Main3Activity.this);
                layoutManager = linearLayoutManager;
                itemAnimator = new DefaultItemAnimator();
                RandomResponse randomResponse = (RandomResponse) message.getData().get("magic");
                list = randomResponse.getResults();
                recycleadapter = new Recycleadapter(list);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(itemAnimator);
                recyclerView.setAdapter(recycleadapter);
                return true;
            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                RetrofitHelper.getRandomresponse().enqueue(new Callback<RandomResponse>() {
                    @Override
                    public void onResponse(Call<RandomResponse> call, Response<RandomResponse> response) {
                        Bundle bundle = new Bundle();
                        Message message = new Message();
                        RandomResponse randomResponse = response.body();
                        bundle.putSerializable("magic",randomResponse);
                        message.setData(bundle);
                        handler.sendMessage(message);
                    }
                    @Override
                    public void onFailure(Call<RandomResponse> call, Throwable t) {

                    }
                });
            }
        }).start();



    }
    public void getMany(){

    }




}
