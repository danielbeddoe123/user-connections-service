package com.beddoed.persistence.controller;

import com.beddoed.model.User;
import com.beddoed.persistence.datastore.ConnectionStore;
import com.beddoed.persistence.datastore.UserStore;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserPersistenceController {

    ConnectionStore connectionStore = new ConnectionStore();
    UserStore userStore = new UserStore();

    @RequestMapping(value = "/persistence/users/connections/{user_id}", method = RequestMethod.GET)
    public List<User> getConnections(@PathVariable String user_id) {
        return connectionStore.getUserConnections(user_id);
    }

    @RequestMapping(value = "/persistence/user", method = RequestMethod.POST)
    public User addUser(@RequestBody User user) {
        userStore.addUser(user);
        return userStore.getUser(user.getId());
    }

    @RequestMapping(value = "/persistence/users/{user_id}", method = RequestMethod.GET)
    public User getUser(@PathVariable String user_id) {
        return userStore.getUser(user_id);
    }

    @RequestMapping(value = "/persistence/users/{user_id_1}/connect/{user_id_2}", method = RequestMethod.PUT)
    public void addConnectionBetweenUsers(@PathVariable String user_id_1, @PathVariable String user_id_2) {
        User user1 = userStore.getUser(user_id_1);
        User user2 = userStore.getUser(user_id_2);
        connectionStore.addConnection(user1, user2);
    }
}
