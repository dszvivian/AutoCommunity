package com.example.autocommunity;



import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.autocommunity.api.ApiRepo;
import com.example.autocommunity.model.Asset;
import com.example.autocommunity.model.ProfileDetails;
import com.example.autocommunity.model.Results;
import com.example.autocommunity.model.User;

import org.json.JSONObject;

import java.util.List;

public class ApiViewModel extends ViewModel {

    private ApiRepo repo;
    private androidx.lifecycle.MutableLiveData<Results> myData;
    private androidx.lifecycle.MutableLiveData<Boolean> isUserAdded;
    private androidx.lifecycle.MutableLiveData<List<User>> getUser;

    private androidx.lifecycle.MutableLiveData<List<ProfileDetails>> getProfileDetails;

    private  androidx.lifecycle.MutableLiveData<Boolean> isProfileInfoUpdated;

    private  androidx.lifecycle.MutableLiveData<Boolean> isAssetAdded;

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

    public MutableLiveData<Boolean> updateProfileData(String username,ProfileDetails pd){
        if(isProfileInfoUpdated==null){
            isProfileInfoUpdated = repo.updateProfileDetails(username, pd);
        }
        return isProfileInfoUpdated;
    }

    public MutableLiveData<List<ProfileDetails>> getProfileDetails(String username){
        if(getProfileDetails==null){
            getProfileDetails = repo.getProfileDetails(username);
        }
        return getProfileDetails;
    }


    public MutableLiveData<Boolean> isAssetAdded(String username,Asset asset){
        if(isAssetAdded==null){
            isAssetAdded = repo.createNewAsset(username,asset);
        }
        return isAssetAdded;
    }



}

