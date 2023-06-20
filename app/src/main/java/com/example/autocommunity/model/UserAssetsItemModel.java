package com.example.autocommunity.model;

public class UserAssetsItemModel {

    int assetImage;
    String assetName;

    public UserAssetsItemModel(int assetImage, String assetName) {
        this.assetImage = assetImage;
        this.assetName = assetName;
    }


    public int getAssetImage() {
        return assetImage;
    }

    public void setAssetImage(int assetImage) {
        this.assetImage = assetImage;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }
}
