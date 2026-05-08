package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/allUsers")
    public List<UserModel> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/add")
    public UserModel newUser(@RequestBody UserModel user){
        return userService.addNewUser(user);
    }

    @GetMapping("/user/{id}")
    public UserModel getUser(@PathVariable Long id) {
        return userService.getById(id);
    }
    

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
    

}
