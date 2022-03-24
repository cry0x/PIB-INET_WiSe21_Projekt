package com.forum.backend.services;

import com.forum.backend.entities.User;
import com.forum.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    public User readUserById(long userId) {
        return this.userRepository.findById(userId).orElseThrow();
    }

    public List<User> readAllUsers() {
        return this.userRepository.findAll();
    }

    public void deleteUser(long userId) {
        this.userRepository.deleteById(userId);
    }

    public User findUserByName(String username) {
        return this.userRepository.findUserByName(username);
    }

}
