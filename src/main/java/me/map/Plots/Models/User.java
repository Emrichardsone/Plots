package me.map.Plots.Models;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
    //fields//
    private Integer userId;

    @NotNull
    @Email
    public String email;

    @NotNull
    public String password;

    @NotNull
    @Size(min=5, max=30)
    private String username;


    //Constructors://
    public User (){

    }
    public User(String email, String password) {
        this.userId = userId;
        this.email = email;
        this.password = password;
    }


        //Getters and Setters//

     public Integer getUserId() {
    return userId;
    }

    public void setUserid(Integer userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    }


    //TODO Create UserFields //

