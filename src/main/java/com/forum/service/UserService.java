package com.forum.service;

import com.forum.excpetions.UserNotFoundException;
import com.forum.repositories.UserRepository;
import com.forum.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return this.userRepository.save(user);
    }

    public User readUserById(Long id) throws UserNotFoundException {
        return this.userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public void deleteUserById(Long id) {
        this.userRepository.deleteById(id);
    }

    public Iterable<User> getAllUsers() {
        return this.userRepository.findAll();
    }

}
