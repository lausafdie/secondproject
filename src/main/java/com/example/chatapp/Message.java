
package com.example.chatapp;
public class Message {
    private String profilePicture;
    private String name;
    private String content;
    private boolean isOwnMessage;

    public Message() {
        // Default constructor required for Firebase Firestore
    }

    public Message(String profilePicture, String name, String content, boolean isOwnMessage) {
        this.profilePicture = profilePicture;
        this.name = name;
        this.content = content;
        this.isOwnMessage = isOwnMessage;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isOwnMessage() {
        return isOwnMessage;
    }

    public void setOwnMessage(boolean ownMessage) {
        isOwnMessage = ownMessage;
    }
}
