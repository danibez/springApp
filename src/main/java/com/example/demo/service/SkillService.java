package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.SkillModel;
import com.example.demo.model.UserModel;
import com.example.demo.repository.SkillRepository;
import com.example.demo.repository.UserRepository;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private UserRepository userRepository;

    public List<SkillModel> getAllSkills() {
        return skillRepository.findAll();
    }

    public SkillModel getSkillById(Long id) {
        return skillRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Habilidade não encontrada"));
    }

    public SkillModel createSkill(SkillModel skill) {
        return skillRepository.save(skill);
    }

    public UserModel addSkillToUser(Long userId, Long skillId) {
        UserModel user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        SkillModel skill = skillRepository.findById(skillId)
                .orElseThrow(() -> new RuntimeException("Habilidade não encontrada"));

        user.getSkills().add(skill);

        return userRepository.save(user);
    }

    public UserModel removeSkillFromUser(Long userId, Long skillId) {
        UserModel user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        SkillModel skill = skillRepository.findById(skillId)
                .orElseThrow(() -> new RuntimeException("Habilidade não encontrada"));

        user.getSkills().remove(skill);

        return userRepository.save(user);
    }

    public boolean deleteSkill(Long id) {
        if (skillRepository.existsById(id)) {
            skillRepository.deleteById(id);
            return true;
        }

        return false;
    }
}