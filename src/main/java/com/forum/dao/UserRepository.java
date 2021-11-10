package com.forum.dao;

import com.forum.object.User;

import java.util.List;

public interface UserRepository {
    User selectUserById(int id);
    List<User> selectAllUsers();
    int addUser(User user);
    void update(User user);
    void delete(User user);
}
