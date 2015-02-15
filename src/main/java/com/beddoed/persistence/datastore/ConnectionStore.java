package com.beddoed.persistence.datastore;

import com.beddoed.model.User;

import java.util.*;

public class ConnectionStore {

    private final Map<User, List<User>> connections = new HashMap<User, List<User>>();

    public List<User> getUserConnections(String userId) {
        Set<User> users = connections.keySet();
        for (User user : users) {
            if (user.getId().equals(userId)) {
                return connections.get(user);
            }
        }
        return null;
    }

    public void addUserConnection(User user1, User user2) {
        addConnection(user1, user2);
        addConnection(user2, user1);
    }

    public void addConnection(User user1, User user2) {
        if (connections.containsKey(user1)) {
            List<User> connectionsForUser = connections.get(user1);
            connectionsForUser.add(user2);
        } else {
            List<User> connectionsForUser = new ArrayList<User>();
            connectionsForUser.add(user2);
            connections.put(user1, connectionsForUser);
        }
    }
}
