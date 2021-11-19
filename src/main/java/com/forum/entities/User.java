package com.forum.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private long id;
    @Column(unique=true)
    private String login_name;
    private String lastname;
    private String firstname;
    @Column(unique=true)
    private String email;
    private String street;
    private int house_number;
    private int postal_code;
    private String town;
    private String country;
    private String phone;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthdate;

    public User() {
    }

    public User(String login_name,
                String lastname,
                String firstname,
                String email) {
        setLogin_name(login_name);
        setLastname(lastname);
        setFirstname(firstname);
        setEmail(email);
    }

    public User(String login_name,
                String lastname,
                String firstname,
                String email,
                String street,
                int house_number,
                int postal_code,
                String town) {
        this(login_name, lastname, firstname, email);

        setStreet(street);
        setHouse_number(house_number);
        setPostal_code(postal_code);
        setTown(town);
    }

    public User(String login_name,
                String lastname,
                String firstname,
                String email,
                String street,
                int house_number,
                int postal_code,
                String town,
                String country,
                String phone,
                LocalDate birthdate) {
        this(login_name, lastname, firstname, email, street, house_number, postal_code, town);

        setCountry(country);
        setPhone(phone);
        setBirthdate(birthdate);
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin_name() {
        return this.login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

}
