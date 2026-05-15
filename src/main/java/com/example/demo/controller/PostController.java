package com.example.demo.controller;

import com.example.demo.model.PostModel;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/user/{userId}")
    public ResponseEntity<PostModel> createPost(@PathVariable Long userId, @RequestBody PostModel post) {
        PostModel savedPost = postService.createPostForUser(userId, post);
        return ResponseEntity.ok(savedPost);
    }

    // Listar todos os posts
    @GetMapping
    public ResponseEntity<List<PostModel>> getAllPosts() {
        List<PostModel> posts = postService.findAll();
        return ResponseEntity.ok(posts);
    }

    // Buscar post por id
    @GetMapping("/{id}")
    public ResponseEntity<PostModel> getPostById(@PathVariable Long id) {
        return postService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Buscar posts de um usuário
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PostModel>> getPostsByUser(@PathVariable Long userId) {
        List<PostModel> posts = postService.findByUserId(userId);
        return ResponseEntity.ok(posts);
    }

    // Deletar post
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.delete(id);
        return ResponseEntity.noContent().build();
    }
}