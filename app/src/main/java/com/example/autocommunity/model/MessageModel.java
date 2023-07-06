package com.example.autocommunity.model;

public class MessageModel {

    String username,message;

    public MessageModel(String username,String message) {
        this.username = username;
        this.message = message;
    }

    public MessageModel() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
