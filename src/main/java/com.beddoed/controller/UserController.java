package com.beddoed.controller;

import com.beddoed.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping("/user")
    public User getUser(@RequestParam(value="name") String name) {
        return new User("id", name);
    }
}
