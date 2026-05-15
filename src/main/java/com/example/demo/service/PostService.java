package com.example.demo.service;

import com.example.demo.model.PostModel;
import com.example.demo.model.UserModel;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    // Criar post para um usuário
    public PostModel createPostForUser(Long userId, PostModel post) {
        Optional<UserModel> userOpt = userRepository.findById(userId);
        if (userOpt.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado");
        }
        post.setUser(userOpt.get());
        return postRepository.save(post);
    }

    public List<PostModel> findAll() {
        return postRepository.findAll();
    }

    public Optional<PostModel> findById(Long id) {
        return postRepository.findById(id);
    }

    public List<PostModel> findByUserId(Long userId) {
        return postRepository.findByUserId(userId);
    }

    public void delete(Long id) {
        postRepository.deleteById(id);
    }
}