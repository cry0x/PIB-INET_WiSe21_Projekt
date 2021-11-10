package com.forum.service;

import com.forum.dao.UserRepository;
import com.forum.object.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(@Qualifier("PostgresUserRepository") UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.selectAllUsers();
    }

    public User getUserById(int id) {
        return userRepository.selectUserById(id);
    }

    public int addUser(User user) {
        return userRepository.addUser(user);
    }
}
