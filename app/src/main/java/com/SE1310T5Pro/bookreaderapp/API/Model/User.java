package com.SE1310T5Pro.bookreaderapp.API.Model;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("username")
    private String username;
    @SerializedName("fullname")
    private String fullname;
    @SerializedName("password")
    private String password;
    @SerializedName("isAdmin")
    private String isAdmin;


    public User(){

    }

    public User(String username, String fullname, String password, String isAdmin) {
        this.username = username;
        this.fullname = fullname;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
