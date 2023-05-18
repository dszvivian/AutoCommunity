package com.example.autocommunity.api;



import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.autocommunity.model.Results;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiRepo {

    public MutableLiveData<Results> requestData(){
        MutableLiveData<Results> myData = new MutableLiveData<Results>();

        ApiService api = RetrofitClient.getInstance().getMyApi();

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


}
