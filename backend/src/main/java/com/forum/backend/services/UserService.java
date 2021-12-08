package com.forum.backend.services;

import com.forum.backend.entities.User;
import com.forum.backend.entities.UserProfilDto;
import com.forum.backend.excpetions.UserNotFoundException;
import com.forum.backend.repositories.UserRepository;
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

    public Iterable<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public void deleteUserById(Long id) {
        this.userRepository.deleteById(id);
    }

    public User findUserByName(String username) {
        return this.userRepository.findUserByName(username);
    }

}
