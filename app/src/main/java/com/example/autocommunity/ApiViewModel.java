package com.example.autocommunity;



import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.autocommunity.api.ApiRepo;
import com.example.autocommunity.model.Results;

public class ApiViewModel extends ViewModel {

    private ApiRepo repo;
    private androidx.lifecycle.MutableLiveData<Results> myData;

    ApiViewModel(){
        repo = new ApiRepo();
    }

    public MutableLiveData<Results> getData(){
        if(myData==null){
            myData = repo.requestData();
        }

        return myData;
    }

}

