package com.in28min.rest.webservices.restfulwebservices.entity;

import java.time.LocalDate;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class User {
    
    private int id;
    
    @Size(min=2, message="Name should have at least 2 characters")
    private String name;
    
    @Past(message="Birth Date should be in the past")
    private LocalDate dateOfBirth;
    
    public User(int id, String name, LocalDate dateOfBirth) {
        super();
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + "]";
    }
    
}
