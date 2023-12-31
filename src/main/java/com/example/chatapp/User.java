package com.example.chatapp;

public class User {
    private String userId;
    private String name;
    private String profileImageUrl;
    private String lastMessage;

    public User() {
        // Default constructor required for Firestore
    }

    public User(String userId, String name, String profileImageUrl, String lastMessage) {
        this.userId = userId;
        this.name = name;
        this.profileImageUrl = profileImageUrl;
        this.lastMessage = lastMessage;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

}

