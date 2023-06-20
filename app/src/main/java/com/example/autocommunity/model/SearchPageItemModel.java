package com.example.autocommunity.model;

public class SearchPageItemModel {

    int profileId;
    String username,description,location;

    public SearchPageItemModel(int profileId, String username, String description, String location) {
        this.profileId = profileId;
        this.username = username;
        this.description = description;
        this.location = location;
    }


    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


}
