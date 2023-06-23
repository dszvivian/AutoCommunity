package com.example.autocommunity.api;

import com.example.autocommunity.model.ProfileDetails;
import com.example.autocommunity.model.Results;
import com.example.autocommunity.model.User;

import org.json.JSONObject;

import java.util.List;

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
    Call<List<User>> getUser(@Path("username") String username);

    @POST("/users/update/{username}")
    Call<ProfileDetails> updateUser(@Path("username")String username, ProfileDetails profileDetails);


}
