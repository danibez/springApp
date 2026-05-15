// package com.example.demo.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import com.example.demo.model.ProfileModel;
// import com.example.demo.service.ProfileService;

// @RestController
// @RequestMapping("/profiles")
// public class ProfileController {

//     @Autowired
//     private ProfileService profileService;

//     @GetMapping
//     public ResponseEntity<List<ProfileModel>> getAllProfiles() {
//         List<ProfileModel> profiles = profileService.getAllProfiles();
//         return ResponseEntity.ok(profiles);
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<ProfileModel> getProfileById(@PathVariable Long id) {
//         ProfileModel profile = profileService.getProfileById(id);
//         return ResponseEntity.ok(profile);
//     }

//     @PostMapping
//     public ResponseEntity<ProfileModel> createProfile(@RequestBody ProfileModel profile) {
//         ProfileModel savedProfile = profileService.createProfile(profile);
//         return ResponseEntity.ok(savedProfile);
//     }

//     @PostMapping("/user/{userId}")
//     public ResponseEntity<ProfileModel> createProfileForUser(@PathVariable Long userId,@RequestBody ProfileModel profile) {
//         ProfileModel savedProfile = profileService.createProfileForUser(userId, profile);
//         return ResponseEntity.ok(savedProfile);
//     }

//     @PutMapping("/{id}")
//     public ResponseEntity<ProfileModel> updateProfile(@PathVariable Long id, @RequestBody ProfileModel profile) {
//         ProfileModel updatedProfile = profileService.updateProfile(id, profile);
//         return ResponseEntity.ok(updatedProfile);
//     }

//     @DeleteMapping("/{id}")
//     public ResponseEntity<Void> deleteProfile(@PathVariable Long id) {
//         boolean deleted = profileService.deleteProfile(id);

//         if (!deleted) {
//             return ResponseEntity.notFound().build();
//         }

//         return ResponseEntity.noContent().build();
//     }
// }