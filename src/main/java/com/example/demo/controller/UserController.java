package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserRequestDTO;
import com.example.demo.dto.UserResponseDTO;
import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/allUsers")
    public List<UserResponseDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/add")
    public UserResponseDTO newUser(@RequestBody UserRequestDTO user){
        return userService.addNewUser(user);
    }

    @GetMapping("/user/{id}")
    public UserModel getUser(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PutMapping("/update/{id}")
    public UserModel updateUser(@RequestBody UserModel user, @PathVariable Long id){
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/user/{id}")
    public BodyBuilder deleteUser(@PathVariable Long id){
        boolean deleted = userService.deleteById(id);
        if (deleted)
            return ResponseEntity.status(HttpStatus.OK);
        return ResponseEntity.status(HttpStatus.NOT_FOUND);

    }
    

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
    

}
