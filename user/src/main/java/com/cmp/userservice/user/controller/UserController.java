package com.cmp.userservice.user.controller;


import com.cmp.userservice.user.entities.User;
import com.cmp.userservice.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        String uuid = UUID.randomUUID().toString();
        System.out.println("Inside create user");
        user.setId(uuid);
        User currUser = userService.createUser(user);
        System.out.println(currUser);
        return new ResponseEntity<>(currUser, HttpStatus.OK);
    }
    @GetMapping("/all")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> aLlUser = userService.getALlUser();
        return new ResponseEntity<>(aLlUser, HttpStatus.OK);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<User> getUser( @PathVariable("id") String id) {
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
