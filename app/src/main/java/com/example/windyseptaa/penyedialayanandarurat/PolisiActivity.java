package com.example.windyseptaa.penyedialayanandarurat;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;


import com.example.windyseptaa.penyedialayanandarurat.adapter.PolisiAdapter;
import com.example.windyseptaa.penyedialayanandarurat.api.PolisiResponse;
import com.example.windyseptaa.penyedialayanandarurat.api.RequestInterface;
import com.example.windyseptaa.penyedialayanandarurat.model.Polisi;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PolisiActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Polisi> data;
    private PolisiAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polisi);
        view();
    }

    private void view(){
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        loadPolisi();
    }

    private void loadPolisi(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://192.168.1.11:8000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInterface request = retrofit.create(RequestInterface.class);
        Call<PolisiResponse> call = request.getPolisi();
        call.enqueue(new Callback<PolisiResponse>() {
            @Override
            public void onResponse(Call<PolisiResponse> call, Response<PolisiResponse> response) {
                PolisiResponse polisiResponse = response.body();
                data = new ArrayList<>(Arrays.asList(polisiResponse.getPolisi()));
                adapter = new PolisiAdapter(data);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<PolisiResponse> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }
}
