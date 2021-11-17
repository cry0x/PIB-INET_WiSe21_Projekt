package com.forum.controller;

import com.forum.entities.User;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Date;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserController userController;

    private static User getTestUser() {
        User user = new User();
        user.setId(1L);
        user.setLogin_name("max.mustermann");
        user.setLastname("Mustermann");
        user.setEmail("Max");
        user.setStreet("Musterstraße");
        user.setHouse_number(1);
        user.setPostal_code(12345);
        user.setTown("Musterhausen");
        user.setCountry("Musterstaat");
        user.setPhone("01234567890");
        user.setBirthdate(Date.valueOf("2021-01-01"));

        return user;
    }

    @Test
    public void getAllUsers() throws Exception {
        given(userController.getAllUsers()).willReturn(ResponseEntity.ok(List.of(getTestUser())));

        mockMvc.perform(get("/api/v1/users")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
/*
    @Test
    public void readUserById() throws Exception {
        long id = 1L;
        @Autowired
        private UserService userService;
        Mockito.when(userService.readUserById(id)).thenReturn(Optional.of(getTestUser()));

        mockMvc.perform(get("/api/v1/users/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(result -> System.out.println(result.toString()));
    }
 */
}
