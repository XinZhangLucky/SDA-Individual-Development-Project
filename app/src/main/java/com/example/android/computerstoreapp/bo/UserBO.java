package com.example.android.computerstoreapp.bo;

import com.example.android.computerstoreapp.dao.impl.UserDAOInternal;
import com.example.android.computerstoreapp.dao.inf.UserDAO;
import com.example.android.computerstoreapp.entity.User;

import java.util.ArrayList;

/**
 * Created by android on 2017-10-24.
 */

public class UserBO {

    private UserDAO mUserDAO;
    private User mUser;
    private ArrayList<User> userArrayList;

    public UserBO() {
        mUserDAO = new UserDAOInternal();//Here we use local internal storage for quickly DB implementation.
    }

    public User createUserForCustomer(String name, String password, String email) {
        User user = new User(name, password, email, 2);
        mUserDAO.register(user);
        return user;
    }

    /**
     * @param email
     * @return true email has been exist in the database
     */
    public boolean hasExistEmail(String email) {
        userArrayList = (ArrayList<User>) mUserDAO.selectAll();
        if(userArrayList == null){
            return false;
        }
        for (User userItem : userArrayList) {
            if (userItem.getUserEmail().equals(email)) {

                return true;
            }
        }
        return false;
    }

    public boolean isValidUserForLogin(String email, String password) {
        userArrayList = (ArrayList<User>) mUserDAO.selectAll();
        if(userArrayList == null){
            return false;
        }
        for (User userItem : userArrayList) {
            if (userItem.getUserEmail().equals(email) && userItem.getUserPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public User getUser(String email){
        userArrayList = (ArrayList<User>) mUserDAO.selectAll();
        if(userArrayList == null){
            return null;
        }
        for (User userItem : userArrayList) {
            if (userItem.getUserEmail().equals(email) ) {
                return userItem;
            }
        }
        return null;
    }

}
