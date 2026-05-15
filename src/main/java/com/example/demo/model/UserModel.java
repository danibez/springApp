package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserModel {
    
    @Id
    @GeneratedValue
    long id;
    String username;
    String password;
    int age;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    @JoinColumn(name="profile_id")
    ProfileModel profile;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference // evita loop infinito ao serializar
    private List<PostModel> posts;
}
