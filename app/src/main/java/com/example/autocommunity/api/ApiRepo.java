package com.example.autocommunity.api;



import static java.util.jar.Pack200.Packer.ERROR;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.autocommunity.model.Asset;
import com.example.autocommunity.model.ProfileDetails;
import com.example.autocommunity.model.Results;
import com.example.autocommunity.model.User;
import com.example.autocommunity.model.UserAssetsItemModel;
import com.example.autocommunity.model.UserDetails;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiRepo {
    ApiService api = RetrofitClient.getInstance().getMyApi();

    public MutableLiveData<Results> requestData(){
        MutableLiveData<Results> myData = new MutableLiveData<Results>();

        api.getData().enqueue(new Callback<Results>() {
                @Override
                public void onResponse(Call<Results> call, Response<Results> response) {
                    if(response.isSuccessful()){
                        myData.setValue(response.body());
                    }
                }

                @Override
            public void onFailure(Call<Results> call, Throwable t) {
                Log.e("Error", "onFailure" + call.toString());
            }
        });

        return myData;
    }


    public MutableLiveData<Boolean> addNewUser(User user){

        MutableLiveData<Boolean> isAdded = new MutableLiveData<Boolean>();

        api.addNewUser(user).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                isAdded.setValue(true);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                isAdded.setValue(false);
            }
        });

        return isAdded;
    }

    public MutableLiveData<List<User>> getUser(String username){
        MutableLiveData<List<User>> myUser = new MutableLiveData<List<User>>();

        api.getUser(username).enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                myUser.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e("Error", "onFailure" + t.toString());
            }
        });

        return myUser;
    }

    public MutableLiveData<Boolean> updateProfileDetails(String username,ProfileDetails pd){
        MutableLiveData<Boolean> isUpdated = new MutableLiveData<>();


       api.updateProfileData(username,pd).enqueue(new Callback<ProfileDetails>() {
           @Override
           public void onResponse(Call<ProfileDetails> call, Response<ProfileDetails> response) {
               if(response.isSuccessful()){
                   isUpdated.setValue(true);
               }
           }

           @Override
           public void onFailure(Call<ProfileDetails> call, Throwable t) {
               isUpdated.setValue(false);
               Log.e(ERROR,t.getMessage());
           }
       });


        return isUpdated;
    }



    public MutableLiveData<List<ProfileDetails>> getProfileDetails(String username){
        MutableLiveData<List<ProfileDetails>> pd = new MutableLiveData<>();

        api.getUserProfileDetails(username).enqueue(new Callback<List<ProfileDetails>>() {
            @Override
            public void onResponse(Call<List<ProfileDetails>> call, Response<List<ProfileDetails>> response) {
                pd.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<ProfileDetails>> call, Throwable t) {
                Log.e(ERROR,t.getMessage());
            }
        });


        return pd;
    }


    public MutableLiveData<Boolean> createNewAsset(String username,Asset asset){

        MutableLiveData<Boolean> isAssetAdded = new MutableLiveData<>();

        api.addNewAsset(username, asset).enqueue(new Callback<Asset>() {
            @Override
            public void onResponse(Call<Asset> call, Response<Asset> response) {
                isAssetAdded.setValue(true);
            }

            @Override
            public void onFailure(Call<Asset> call, Throwable t) {
                isAssetAdded.setValue(false);
                Log.e(ERROR,t.getMessage());
            }
        });



        return isAssetAdded;
    }


    public MutableLiveData<List<Asset>> getAssetsByUsername(String username){
        MutableLiveData<List<Asset>> assets = new MutableLiveData<>();

        api.getAssetsByUsername(username).enqueue(new Callback<List<Asset>>() {
            @Override
            public void onResponse(Call<List<Asset>> call, Response<List<Asset>> response) {
                assets.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Asset>> call, Throwable t) {
                Log.e(ERROR,t.getMessage());
            }
        });

        return assets;
    }


    public MutableLiveData<List<UserDetails>> getAllUsers(){
        MutableLiveData<List<UserDetails>> allUsers = new MutableLiveData<>();

        api.getALlUsers().enqueue(new Callback<List<UserDetails>>() {
            @Override
            public void onResponse(Call<List<UserDetails>> call, Response<List<UserDetails>> response) {
                allUsers.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<UserDetails>> call, Throwable t) {
                Log.e(ERROR,t.getMessage());
            }
        });

        return allUsers;
    }





}
