package com.example.autocommunity.model;

import com.google.gson.annotations.SerializedName;

public class CompletePostModel {

    @SerializedName("postImage")
    String postImage;

    @SerializedName("username")
    String username;



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public CompletePostModel(String postImage, String username) {
        this.postImage = postImage;
        this.username = username;
    }

    public String getPostImage() {
        return postImage;
    }

    public void setPostImage(String postImage) {
        this.postImage = postImage;
    }
}
