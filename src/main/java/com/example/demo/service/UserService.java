package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserRequestDTO;
import com.example.demo.dto.UserResponseDTO;
import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    
    public List<UserResponseDTO> getAllUsers(){
        List<UserModel> userList = userRepository.findAll();
        List<UserResponseDTO> response = new ArrayList<UserResponseDTO>();
        for (UserModel user : userList) {
            response.add(new UserResponseDTO(user.getId(),
                                            user.getUsername(),
                                            user.getAge()));
        }
        return response;
    }

    public UserResponseDTO addNewUser(UserRequestDTO user){
        
        UserModel newUser = new UserModel();
        newUser.setPassword(user.getPassword());
        newUser.setAge(user.getAge());
        newUser.setUsername(user.getUsername());

        UserModel userSaved = userRepository.save(newUser);

        UserResponseDTO response = new UserResponseDTO( userSaved.getId(),
                                                        userSaved.getUsername(),
                                                        userSaved.getAge());
        
        return response;
    }

    public UserModel getById(Long id){
        return userRepository.findById(id).get();
    }

    public UserModel updateUser(Long id, UserModel newUser){
        UserModel user = userRepository.findById(id).get();
        user.setAge(newUser.getAge());
        user.setPassword(newUser.getPassword());
        user.setUsername(newUser.getUsername());

        return userRepository.save(user);
    }

    public boolean deleteById(Long id) {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        } else 
            return false;
    }


}
