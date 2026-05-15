package com.example.demo.dto;

import java.util.List;

import com.example.demo.model.PostModel;
import com.example.demo.model.ProfileModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserResponseDTO {
    
    private long id;
    private String username;
    private int age;
    private ProfileModel profileModel;
    private List<PostModel> postModel;
}
