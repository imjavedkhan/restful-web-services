package com.in28minutes.restfulwebservices.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @Size(min=2, message = "Name should have atleast 2 characters")
    private String name;

    @Past(message = "Birth Date should be in the past")
    private LocalDateTime dob;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Post> postList;

    public User() {
    }

    public User(Integer id, String name, LocalDateTime dob) {
        this.id = id;
        this.name = name;
        this.dob = dob;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                '}';
    }
}
