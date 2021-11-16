package com.forum.service;

import com.forum.repositories.UserRepository;
import com.forum.entities.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createOrUpdateUser(User user) {
        return this.userRepository.save(user);
    }

    public Optional<User> readUserById(Long id) {
        return this.userRepository.findById(id);
    }

    public void deleteUserById(Long id) {
        this.userRepository.deleteById(id);
    }

    public Iterable<User> getAllUsers() {
        return this.userRepository.findAll();
    }

}
