package forum.dao;

import forum.object.User;

import java.util.List;

public interface UserRepository {
    User getUserById(int id);
    List<User> getUsers();
    void add(User user);
    void update(User user);
    void delete(User user);
}
