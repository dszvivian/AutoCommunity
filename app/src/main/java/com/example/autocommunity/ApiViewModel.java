package com.example.autocommunity;



import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.autocommunity.api.ApiRepo;
import com.example.autocommunity.pages.model.Results;
import com.example.autocommunity.pages.model.User;

import java.util.List;

public class ApiViewModel extends ViewModel {

    private ApiRepo repo;
    private androidx.lifecycle.MutableLiveData<Results> myData;
    private androidx.lifecycle.MutableLiveData<Boolean> isUserAdded;
    private androidx.lifecycle.MutableLiveData<List<User>> getUser;

    public ApiViewModel(){
        repo = new ApiRepo();
    }

    public MutableLiveData<Results> getData(){
        if(myData==null){
            myData = repo.requestData();
        }
        return myData;
    }

    public MutableLiveData<Boolean> addNewUser(User user){
        if(isUserAdded==null){
            isUserAdded = repo.addNewUser(user);
        }
        return isUserAdded;
    }

    public MutableLiveData<List<User>> getUser(String username){
        if(getUser==null){
            getUser = repo.getUser(username);
        }
        return getUser;
    }





}

