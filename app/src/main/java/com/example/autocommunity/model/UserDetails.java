package com.example.autocommunity.model;

import com.google.gson.annotations.SerializedName;

public class UserDetails {

    @SerializedName("username")
    String username;

    @SerializedName("email")
    String email;

    @SerializedName("pName")
    String pName;

    @SerializedName("pPicture")
    String pPicture;

    @SerializedName("pDescription")
    String pDesc;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserDetails(String username, String email, String pName, String pPicture, String pDesc) {
        this.username = username;
        this.email = email;
        this.pName = pName;
        this.pPicture = pPicture;
        this.pDesc = pDesc;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpPicture() {
        return pPicture;
    }

    public void setpPicture(String pPicture) {
        this.pPicture = pPicture;
    }

    public String getpDesc() {
        return pDesc;
    }

    public void setpDesc(String pDesc) {
        this.pDesc = pDesc;
    }
}
