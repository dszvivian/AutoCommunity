package com.example.autocommunity.model;

import com.google.gson.annotations.SerializedName;

public class Results {

    @SerializedName("message")
    private String message;


    public Results(String message) {
        this.message = message;
    }

    public String getName() {
        return message;
    }
}
