package com.forum.service;

import com.forum.entities.User;
import com.forum.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    private List<User> getIterableUserList() {
        return Arrays.asList(getMaxMustermannWithoutId(), getEricaMustermannUser());
    }

    private User getMaxMustermannWithoutId() {
        User user = new User();
        user.setLogin_name("max.mustermann");
        user.setLastname("Mustermann");
        user.setFirstname("Max");
        user.setEmail("max.mustermann@mail.com");

        return user;
    }

    private User getMaxMustermannWithId() {
        User user = new User();
        user.setId(1L);
        user.setLogin_name("max.mustermann");
        user.setLastname("Mustermann");
        user.setFirstname("Max");
        user.setEmail("max.mustermann@mail.com");

        return user;
    }

    private User getEricaMustermannUser() {
        return new User("erica.mustermann",
                "Mustermann",
                "Erica",
                "erica.mustermann@mail.com");
    }

    @Test
    public void findAllTest() {
        Mockito.when(userRepository.findAll()).thenReturn(getIterableUserList());

        assertIterableEquals(getIterableUserList(), userService.getAllUsers());
    }

    @Test
    public void findAllEmptyTest() {
        Mockito.when(userRepository.findAll()).thenReturn(new ArrayList<>());

        assertFalse(userService.getAllUsers().iterator().hasNext());
    }

    @Test
    public void createUserTest() {
        User expectedUser = getMaxMustermannWithId();

        Mockito.when(userRepository.save(getMaxMustermannWithoutId())).thenReturn(expectedUser);

        assertEquals(expectedUser, userService.createUser(getMaxMustermannWithoutId()));
    }
}
