package com.example.android.computerstoreapp.dao.impl;

import com.example.android.computerstoreapp.dao.inf.UserDAO;
import com.example.android.computerstoreapp.entity.User;

import java.util.List;


public class UserDAOWebRemote implements UserDAO {

    @Override
    public boolean register(User user) {
        return false;
    }

    @Override
    public List<User> selectAll() {
        return null;
    }
}
