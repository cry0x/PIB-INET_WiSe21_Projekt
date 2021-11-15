package com.forum.entities;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

    public User(String lastname, String firstname, String email, String street, int house_number, int postal_code, String town) {
        this(lastname, firstname, email);
        this.street = street;
        this.house_number = house_number;
        this.postal_code = postal_code;
        this.town = town;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
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

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse_number() {
        return this.house_number;
    }

    public void setHouse_number(int house_number) {
        this.house_number = house_number;
    }

    public int getPostal_code() {
        return this.postal_code;
    }

    public void setPostal_code(int postal_code) {
        this.postal_code = postal_code;
    }

    public String getTown() {
        return this.town;
    }

    public void setTown(String town) {
        this.town = town;
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
