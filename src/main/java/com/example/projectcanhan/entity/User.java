package com.example.projectcanhan.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String Id;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;


    public String getId() {
        return Id;
    }

    public void setId(String id) {
        this.Id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
