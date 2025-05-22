package com.example.teachlearn.Services;

import com.example.teachlearn.Model.User;
import com.example.teachlearn.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User register(User user) {
        user.setVerificationToken(UUID.randomUUID().toString());
        user.setVerified(false);
        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("USER");
        }
        return userRepository.save(user);
    }

    public boolean verifyEmail(String token) {
        User user = userRepository.findByVerificationToken(token);
        if (user != null) {
            user.setVerified(true);
            user.setVerificationToken(null);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public List<User> findMatches(User user) {
        return userRepository.findAll().stream()
            .filter(other -> !other.getId().equals(user.getId()))
            .filter(other ->
                other.getSkillsToTeach().stream().anyMatch(skill -> user.getSkillsToLearn().contains(skill)) &&
                other.getSkillsToLearn().stream().anyMatch(skill -> user.getSkillsToTeach().contains(skill))
            )
            .collect(Collectors.toList());
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(Long id, User updatedUser) {
        return userRepository.findById(id).map(user -> {
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword());
            user.setBio(updatedUser.getBio());
            user.setExperience(updatedUser.getExperience());
            user.setSkillsToTeach(updatedUser.getSkillsToTeach());
            user.setSkillsToLearn(updatedUser.getSkillsToLearn());
            user.setProfileImageUrl(updatedUser.getProfileImageUrl());
            user.setPortfolioLink(updatedUser.getPortfolioLink());
            user.setRole(updatedUser.getRole());
            return userRepository.save(user);
        }).orElse(null);
    }

    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
