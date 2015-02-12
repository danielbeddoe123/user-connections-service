package com.beddoed.controller;

import com.beddoed.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public String getAllUsersConnectedWithUser(@PathVariable String id) {
        return id;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String addUser(@RequestBody User user) {
        return user.toString();
    }

    @RequestMapping(value = "/users/{id_1}/connect/{id_2}", method = RequestMethod.PUT)
    public String addConnectionBetweenUsers(@PathVariable String id_1, @PathVariable String id_2) {
        return "Connecting: " + id_1 + " with " + id_2;
    }
}
