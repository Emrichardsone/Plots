package me.map.Plots.Models;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "user")
public class User {


    //fields//
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Email(message = "Please enter a valid email")
    @Size(min=8)
    private String email;

    @NotNull
    private String password;

    @OneToMany
    @JoinColumn(name="user_id")
    private List<MapStory> stories = new ArrayList<>();


    //Constructors://
    public User() {
    }

    public User(String email, String password, List<MapStory> stories) {
        this.stories=stories;
        this.email = email;
        this.password = password;
    }


    //Getters and Setters//

    public int getId() {
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

    public List<MapStory> getMapStory(){
        return stories;
    }


}




