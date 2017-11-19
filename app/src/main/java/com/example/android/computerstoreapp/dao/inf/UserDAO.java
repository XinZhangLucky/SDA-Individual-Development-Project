package com.example.android.computerstoreapp.dao.inf;

import com.example.android.computerstoreapp.entity.User;

import java.util.List;

/**
 * Created by android on 2017-10-23.
 */

public interface UserDAO {
    /**
     *
     * @param user
     * @return
     */
    public boolean register(User user);

    public List<User> selectAll();
}
