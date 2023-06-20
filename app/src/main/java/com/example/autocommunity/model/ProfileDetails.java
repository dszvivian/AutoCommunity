package com.example.autocommunity.model;

import com.google.gson.annotations.SerializedName;

public class ProfileDetails {

    @SerializedName("pName")
    private String pName;

    @SerializedName("pPicture")
    private String pPicture;

    @SerializedName("pDescription")
    private String pDescription;

    public ProfileDetails(String pName, String pPicture, String pDescription) {
        this.pName = pName;
        this.pPicture = pPicture;
        this.pDescription = pDescription;
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

    public String getpDescription() {
        return pDescription;
    }

    public void setpDescription(String pDescription) {
        this.pDescription = pDescription;
    }
}
