package com.example.roomjava.database;

import android.app.Application;

import com.example.roomjava.managers.RoomManager;
import com.example.roomjava.model.User;

import java.util.List;

public class UserRepository {
    private UserDao userDao;

    public UserRepository(Application application) {
        RoomManager db = RoomManager.getDatabase(application);
        userDao = db.usersDao();
    }

    public List<User> getUsers() {
        return userDao.getUsers();
    }

    public void saveUser(User user) {
        userDao.saveUser(user);
    }
}
