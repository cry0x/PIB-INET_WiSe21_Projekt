package com.forum.object;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    private int id;
    private String lastname;
    private String firstname;
    private String email;
    private String street;
    private int house_number;
    private int postal_code;
    private String town;

    public User() {
    }

    public User(String lastname, String firstname, String email) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
    }

    public User(int id, String lastname, String firstname, String email) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("Id: %d Lastname: %s Firstname: %s Email: %s",
                getId(),
                getLastname(),
                getFirstname(),
                getEmail());
    }
}
