package com.example.android.computerstoreapp.dao.inf;

import com.example.android.computerstoreapp.entity.User;

import java.util.List;

public interface UserDAO {
    public boolean register(User user);

    public List<User> selectAll();
}
