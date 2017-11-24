package com.example.android.computerstoreapp.entity;

import org.litepal.crud.DataSupport;

public class User extends DataSupport {
    private String userName;
    private String userEmail;
    private String userPassword;
    private int userType;

    public User(String userName, String userPassword, String userEmail, int userType) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userType = userType;
        this.userEmail = userEmail;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

}
