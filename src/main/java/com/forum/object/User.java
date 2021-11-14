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

    public User(@JsonProperty("lastname") String lastname,
                @JsonProperty("firstname") String firstname,
                @JsonProperty("email") String email) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
    }

    public User(@JsonProperty("id") int id,
                @JsonProperty("lastname") String lastname,
                @JsonProperty("firstname") String firstname,
                @JsonProperty("email") String email) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
