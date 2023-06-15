package com.example.autocommunity.model;

public class HomePageItemsModel {

    int postImage ;
    int profileImage;

    public HomePageItemsModel(int postImage, int profileImage, String username) {
        this.postImage = postImage;
        this.profileImage = profileImage;
        this.username = username;
    }

    String username;

    public int getPostImage() {
        return postImage;
    }

    public void setPostImage(int postImage) {
        this.postImage = postImage;
    }

    public int getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(int profileImage) {
        this.profileImage = profileImage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
