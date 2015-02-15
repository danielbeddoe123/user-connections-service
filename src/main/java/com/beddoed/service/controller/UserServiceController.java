package com.beddoed.service.controller;

import com.beddoed.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class UserServiceController {

    RestTemplate restTemplate = new RestTemplate();
    String getConnectionsURL = "http://localhost:8080/persistence/users/connections/%s";
    String addUserURL = "http://localhost:8080/persistence/user";
    String addConnectionURL = "http://localhost:8080/persistence/users/%s/connect/%s";

    @RequestMapping(value = "/users/{user_id}", method = RequestMethod.GET)
    public String getAllUsersConnectedWithUser(@PathVariable String user_id) {
        ResponseEntity<List> response = restTemplate.getForEntity(String.format(getConnectionsURL, user_id), List.class);
        List<User> users = response.getBody();
        String connection = "";
        for (User user : users) {
            connection += user + " ";
        }
        return connection;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String addUser(@RequestBody User user) {
        ResponseEntity<User> response = restTemplate.postForEntity(addUserURL, user, User.class);
        return response.getBody().getId();
    }

    @RequestMapping(value = "/users/{user_id_1}/connect/{user_id_2}", method = RequestMethod.PUT)
    public String addConnectionBetweenUsers(@PathVariable String user_id_1, @PathVariable String user_id_2) {
        restTemplate.put(String.format(addConnectionURL, user_id_1, user_id_2), null, new Object());
        return "Connecting: " + user_id_1 + " with " + user_id_2;
    }
}
