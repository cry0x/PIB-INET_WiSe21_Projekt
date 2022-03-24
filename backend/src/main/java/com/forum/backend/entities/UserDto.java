package com.forum.backend.entities;

import lombok.Data;

@Data
public class UserDto {

    private String fistName;
    private String lastName;

    public User getUser() {
        User user = new User();

        user.setFirstname(getFistName());
        user.setLastname(getLastName());

        return user;
    }

}
