package forum.controller;

import forum.dao.UserRepository;
import forum.dao.UserRepositoryImpl;
import forum.object.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private UserRepository userRepositoryImpl = new UserRepositoryImpl();

    @GetMapping(value = "/users")
    public List<User> all() {
        return userRepositoryImpl.getUsers();
    }

    @GetMapping("/users/{id}")
    public User userById(@PathVariable int id) {
        return userRepositoryImpl.getUserById(id);
    }
}
