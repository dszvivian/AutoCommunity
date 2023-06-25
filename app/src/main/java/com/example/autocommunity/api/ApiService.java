package com.example.autocommunity.api;

import com.example.autocommunity.model.Asset;
import com.example.autocommunity.model.Post;
import com.example.autocommunity.model.ProfileDetails;
import com.example.autocommunity.model.Results;
import com.example.autocommunity.model.User;
import com.example.autocommunity.model.UserAssetsItemModel;
import com.example.autocommunity.model.UserDetails;

import org.json.JSONObject;

import java.util.ArrayList;
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

    @GET("/users")
    Call<List<UserDetails>> getALlUsers();

    @GET("/users/{username}")
    Call<List<User>> getUser(@Path("username") String username);

    @POST("/users/update/{username}")
    Call<ProfileDetails> updateProfileData(@Path("username")String username,@Body ProfileDetails pd);

    @GET("/users/{username}")
    Call<List<ProfileDetails>> getUserProfileDetails(@Path("username") String username);

    @POST("/users/assets/{username}")
    Call<Asset> addNewAsset(@Path("username")String username,@Body Asset asset);

    @GET("/users/assets/{username}")
    Call<List<Asset>> getAssetsByUsername(@Path("username") String username);

    @GET("/posts")
    Call<ArrayList<Post>> getAllPosts();

    @POST("/post/{username}")
    Call<Post> addNewPost(@Path("username")String username,@Body Post post);

}
