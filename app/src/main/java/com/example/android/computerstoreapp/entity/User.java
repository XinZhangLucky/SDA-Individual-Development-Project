package com.example.android.computerstoreapp.entity;

import org.litepal.crud.DataSupport;


/**
 * Created by android on 2017-10-23.
 */

public class User extends DataSupport  {

    private String userName;
    private String userEmail;
    private String userPassword;
    private int userType;

    public User(String userName, String userPassword, String userEmail,int userType) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userType=userType;
        this.userEmail=userEmail;

    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

}
