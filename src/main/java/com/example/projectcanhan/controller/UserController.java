package com.example.projectcanhan.controller;

import com.example.projectcanhan.dto.request.UserCreationRequest;
import com.example.projectcanhan.dto.request.UserUpdateRequest;
import com.example.projectcanhan.entity.User;
import com.example.projectcanhan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;

    @PostMapping
    User createUser(@RequestBody UserCreationRequest request) {
        return userService.createUser(request);
    }

    @GetMapping
    List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{userID}")
    User getUser(@PathVariable("userID") String userID) {
        return userService.getUser(userID);
    }

    @PutMapping("/{userID}")
    User updateUser(@PathVariable String userID, @RequestBody UserUpdateRequest request) {
        return userService.updateUser(userID, request);
    }

    @DeleteMapping("/{userID}")
    String deleteUser(@PathVariable String userID) {
        userService.deleteUser(userID);
        return "User has been deleted!";
    }
}
