package com.example.UserManagement.controller;



import com.example.UserManagement.model.UserManagement;
import com.example.UserManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/getAllUsers")
    public List<UserManagement> getAllUsers()
    {
        return userService.getAllUsers();
    }

    @PostMapping(value = "/addUser")
    public String addUser(@RequestBody UserManagement userManagement)
    {
       return userService.addMyUser(userManagement);
    }

    @GetMapping(value = "/getUserId/{id}")
    public UserManagement getUserById(@PathVariable String id){
        return userService.getUserBasedId(id);
    }

    @PutMapping(value = "/updateUser/{id}")
    public String updateUser(@PathVariable int id,@RequestBody UserManagement userManagement){
        return userService.updateUser(id,userManagement);
    }

    @DeleteMapping(value = "/deleteUser/{id}")
    public String deleteUserById(@PathVariable String id){
        return userService.removeUserId(id);
    }
}
