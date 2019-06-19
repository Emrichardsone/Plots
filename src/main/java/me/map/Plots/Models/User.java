package me.map.Plots.Models;

import org.hibernate.validator.constraints.Email;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity
public class User {

    //fields//
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String password;


    //Constructors://
    public User() {
    }

    public User(String email, String password) {

        this.email = email;
        this.password = password;
    }


    //Getters and Setters//

    public int id() {
        return id;
    }

    public void setUserid(int id) {
        this.id = id;
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


}




