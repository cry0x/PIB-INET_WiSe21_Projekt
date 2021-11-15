package com.forum.service;

import com.forum.repositories.UserRepository;
import com.forum.entities.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return this.userRepository.save(user);
    }

    public Optional<User> readUser(Long id) {
        return this.userRepository.findById(id);
    }

    public void updateUser(User user) {
        this.userRepository.save(user);
    }

    public void deleteUser(User user) {
        this.userRepository.delete(user);
    }

    public Iterable<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public Long count() {
        return this.userRepository.count();
    }

}
