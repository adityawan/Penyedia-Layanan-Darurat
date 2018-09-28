package com.example.windyseptaa.penyedialayanandarurat.api;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {

    @GET("polisi")
    Call<PolisiResponse> getPolisi();
}
