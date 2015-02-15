package com.beddoed.persistence.datastore;

import com.beddoed.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserStore {
    private final List<User> users = new ArrayList<User>();

    public void addUser(User user) {
        if(!users.contains(user)) {
            users.add(user);
        }
    }

    public User getUser(String id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }
}
