package com.example.autocommunity.api;

import androidx.annotation.AnyRes;

import com.example.autocommunity.model.Results;
import com.example.autocommunity.model.User;

import kotlin.ParameterName;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {

    String BASE_URL = "https://creepy-hen-panama-hat.cyclic.app/"; // Experimental purpose

    @GET("/")
    Call<Results> getData();

    @POST("/users")
    Call<User> addNewUser(@Body User user);

    @GET("/users/{username}")
    Call<User> getUser(@Path("username") String username);


}
