package com.forum.backend.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Configurable
public class UserDto {

    @Autowired
    public BCryptPasswordEncoder bCryptPasswordEncoder;

    @NotNull
    @NotEmpty
    private String salutation;
    @NotNull
    @NotEmpty
    private String fName;
    @NotNull
    @NotEmpty
    private String lName;
    @NotNull
    @NotEmpty
    private String email;
    @NotNull
    @NotEmpty
    private String login;
    @NotNull
    @NotEmpty
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birth;
    @NotNull
    @NotEmpty
    private String pwd;

    public UserDto() {
    }

    public User getUser() {
        User user = new User();

        user.setFirstname(getfName());
        user.setLastname(getlName());
        user.setEmail(getEmail());
        user.setLogin_name(getLogin());
        user.setBirthdate(getBirth());
        user.setPassword(getPwd());

        return user;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

}
