package com.example.autocommunity.model;

import com.google.gson.annotations.SerializedName;

public class Asset {

    @SerializedName("assetName")
    String assetName;

    @SerializedName("assetImage")
    String assetImage;

    public Asset(String assetName, String assetImage) {
        this.assetName = assetName;
        this.assetImage = assetImage;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getAssetImage() {
        return assetImage;
    }

    public void setAssetImage(String assetImage) {
        this.assetImage = assetImage;
    }
}
