package com.example.autocommunity.api;



import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.autocommunity.pages.model.Results;
import com.example.autocommunity.pages.model.User;

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

    public MutableLiveData<User> getUser(String username){
        MutableLiveData<User> myUser = new MutableLiveData<User>();

        api.getUser(username).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                myUser.setValue(response.body());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("Error", "onFailure" + t.toString());
            }
        });

        return myUser;
    }



}
