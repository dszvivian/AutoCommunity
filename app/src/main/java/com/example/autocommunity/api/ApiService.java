package com.example.autocommunity.api;

import androidx.annotation.AnyRes;

import com.example.autocommunity.model.Results;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    String BASE_URL = "https://creepy-hen-panama-hat.cyclic.app/"; // Experimental purpose

    @GET("/")
    Call<Results> getData();


}
