package com.example.android.computerstoreapp.dao.impl;

import android.database.Cursor;

import com.example.android.computerstoreapp.dao.inf.UserDAO;
import com.example.android.computerstoreapp.entity.User;

import org.litepal.crud.DataSupport;


import java.util.ArrayList;
import java.util.List;

public class UserDAOInternal implements UserDAO {

    public boolean register(User user) {
        return user.save();
    }

    public List<User> selectAll() {
        List<User> result = new ArrayList<>();
        Cursor cursor = DataSupport.findBySQL("SELECT * FROM user");
        while (cursor.moveToNext()) {
            String username = cursor.getString(cursor.getColumnIndex("username"));
            String useremail = cursor.getString(cursor.getColumnIndex("useremail"));
            String userpassword = cursor.getString(cursor.getColumnIndex("userpassword"));
            int usertype = cursor.getInt(cursor.getColumnIndex("usertype"));
            result.add(new User(username, userpassword, useremail, usertype));
        }
        return result;
    }
}
