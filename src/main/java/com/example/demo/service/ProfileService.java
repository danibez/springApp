// package com.example.demo.service;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo.model.ProfileModel;
// import com.example.demo.model.UserModel;
// import com.example.demo.repository.ProfileRepository;
// import com.example.demo.repository.UserRepository;

// @Service
// public class ProfileService {

//     @Autowired
//     ProfileRepository profileRepository;
    
//     @Autowired
//     UserRepository userRepository;

//     public List<ProfileModel> getAllProfiles() {
//         return profileRepository.findAll();
//     }

//     public ProfileModel getProfileById(Long id) {
//         return profileRepository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("Perfil não encontrado"));
//     }

//     public ProfileModel createProfile(ProfileModel profile) {
//         return profileRepository.save(profile);
//     }

//     public ProfileModel createProfileForUser(Long userId, ProfileModel profile) {
//         UserModel user = userRepository.findById(userId)
//                 .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

//         if (user.getProfile() != null) {
//             throw new RuntimeException("Este usuário já possui um perfil");
//         }
        
//         ProfileModel savedProfile = profileRepository.save(profile);

//         user.setProfile(savedProfile);
//         userRepository.save(user);

//         return savedProfile;
//     }

//     public ProfileModel updateProfile(Long id, ProfileModel newProfile) {
//         ProfileModel profile = profileRepository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("Perfil não encontrado"));

//         profile.setFullName(newProfile.getFullName());
//         profile.setPhone(newProfile.getPhone());
//         profile.setBio(newProfile.getBio());

//         return profileRepository.save(profile);
//     }

//     public boolean deleteProfile(Long id) {
//         if (profileRepository.existsById(id)) {
//             profileRepository.deleteById(id);
//             return true;
//         }

//         return false;
//     }
// }