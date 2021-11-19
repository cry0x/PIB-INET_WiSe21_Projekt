package com.forum.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.forum.entities.User;

import com.forum.excpetions.UserNotFoundException;
import com.forum.service.UserService;
import org.junit.jupiter.api.Test;
import org.postgresql.util.PSQLException;
import org.postgresql.util.PSQLState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    private static User getTestUser() {
        User user = new User();
        user.setId(1L);
        user.setLogin_name("max.mustermann");
        user.setLastname("Mustermann");
        user.setEmail("Max");
        user.setStreet("Musterstrasse");
        user.setHouse_number(1);
        user.setPostal_code(12345);
        user.setTown("Musterhausen");
        user.setCountry("Musterstaat");
        user.setPhone("01234567890");
        user.setBirthdate(LocalDate.of(2021, 01, 01));

        return user;
    }

    @Test
    public void readUserById() throws Exception {
        long id = 1L;
        given(userService.readUserById(id)).willReturn(getTestUser());

        mockMvc.perform(get(String.format("/api/v1/users/%d", id)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(content().json(new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(getTestUser())))
                .andExpect(result -> System.out.println(result.getResponse().getContentAsString()));
    }

    @Test
    public void readUserByIdUserNotFound() throws Exception {
        long id = 1L;
        given(userService.readUserById(id)).willThrow(new UserNotFoundException());

        mockMvc.perform(get(String.format("/api/v1/users/%d", id)))
                .andExpect(status().isNotFound())
                .andExpect(content().string("User not found!"));
    }

}
