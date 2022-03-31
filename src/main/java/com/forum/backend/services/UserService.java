package com.forum.backend.services;

import com.forum.backend.entities.User;
import com.forum.backend.repositories.CommentRepository;
import com.forum.backend.repositories.PostRepository;
import com.forum.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public UserService(UserRepository userRepository, PostRepository postRepository, CommentRepository commentRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    public User readUserById(long userId) throws Exception {
        return this.userRepository.findById(userId).orElseThrow(() -> new Exception(String.format("User with Id: %s doesnt exist!", userId)));
    }

    public List<User> readAllUsers() {
        return this.userRepository.findAll();
    }

    @Transactional
    public void deleteUser(long userId) {
        this.commentRepository.deleteAllByCreator_Id(userId);
        this.postRepository.deleteAllByCreator_Id(userId);
        this.userRepository.deleteById(userId);
    }

    public User findUserByName(String username) {
        return this.userRepository.findUserByName(username);
    }

}
